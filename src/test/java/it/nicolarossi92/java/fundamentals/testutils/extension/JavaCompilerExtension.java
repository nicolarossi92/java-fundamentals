package it.nicolarossi92.java.fundamentals.testutils.extension;

import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.Compile;
import it.nicolarossi92.java.fundamentals.testutils.process.java.JavaProcessWrapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class JavaCompilerExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Integer.class) && parameterContext.isAnnotated(Compile.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        String tempDirectory = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("outputDir", String.class);
        try {
            if (parameterContext.isAnnotated(Compile.class)) {
                Compile compileAnnotation = parameterContext.getParameter().getAnnotation(Compile.class);
                String[] sourcePaths = compileAnnotation.sourcePath();
                String[] sourceClassPaths = new String[sourcePaths.length];
                String mainClassPath = compileAnnotation.mainClassPath();
                Resource mainClassPathResource = new ClassPathResource(mainClassPath);
                for (int i = 0; i < sourcePaths.length; i++) {
                    Resource resource = new ClassPathResource(sourcePaths[i]);
                    sourceClassPaths[i] = resource.getFile().getAbsolutePath();
                }

                String[] classPaths = compileAnnotation.classPath();
                String[] classPathResources = new String[classPaths.length];
                for(int i = 0; i < classPaths.length; i++){
                    Resource resource = new ClassPathResource(classPaths[i]);
                    classPathResources[i] = resource.getFile().getAbsolutePath();
                }
                String[] classesToCompile = compileAnnotation.classesToCompile();

                String[] modulePaths = compileAnnotation.modulePath();
                for(int i = 0; i < modulePaths.length; i++){
                    Resource resource = new ClassPathResource(modulePaths[i]);
                    modulePaths[i] = resource.getFile().getAbsolutePath();
                }
                String[] modules = compileAnnotation.modules();
                JavaProcessWrapper.JavacProcessWrapperBuilder builder = JavaProcessWrapper.builderJavacProcess();
                if(sourceClassPaths.length != 0) {
                    builder.withSourcePath(sourceClassPaths);
                }
                builder.withOutputDir(tempDirectory);
                if (classPaths.length != 0) {
                    builder.withClassPath(classPathResources);
                }
                if (modulePaths.length != 0) {
                    builder.withModulePath(modulePaths);
                }

                for (String module : modules) {
                    builder.withModule(module);
                }
                builder.withSources(classesToCompile);
                return builder.build(mainClassPathResource.getFile().getAbsolutePath()).execute();
            }
        } catch (Exception e) {
            throw new ParameterResolutionException(e.getMessage());
        }
        return -1;
    }
}
