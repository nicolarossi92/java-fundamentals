package it.nicolarossi92.java.fundamentals.testutils.extension;

import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.ExecuteJavaProgram;
import it.nicolarossi92.java.fundamentals.testutils.process.java.JavaProcessWrapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class JavaRunnerExtension implements ParameterResolver {


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Integer.class) && parameterContext.isAnnotated(ExecuteJavaProgram.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        String tempDirectory = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).get("outputDir", String.class);
        try {
            if (parameterContext.isAnnotated(ExecuteJavaProgram.class)) {
                ExecuteJavaProgram executeAnnotation = parameterContext.getParameter().getAnnotation(ExecuteJavaProgram.class);
                String[] classPaths = executeAnnotation.classPath();
                String[] classPathsResources = new String[classPaths.length + 1];
                for (int i = 0; i < classPathsResources.length; i++){
                    if(i == classPaths.length){
                        classPathsResources[i] = tempDirectory;
                    }else{
                        Resource resource = new ClassPathResource(classPaths[i]);
                        classPathsResources[i] = resource.getFile().getAbsolutePath();
                    }
                }
                String[] modulePaths = executeAnnotation.modulePath();
                for(int i = 0; i < modulePaths.length; i++){
                    Resource resource = new ClassPathResource(modulePaths[i]);
                    modulePaths[i] = resource.getFile().getAbsolutePath();
                }
                String[] modules = executeAnnotation.modules();
                String[] commandLineArguments = executeAnnotation.commandLineArguments();
                String mainClass = executeAnnotation.mainClass();
                JavaProcessWrapper.JavaProcessWrapperBuilder builder = JavaProcessWrapper.builderJavaProcess();

                builder.withClassPath(classPathsResources);

                if (modulePaths.length != 0) {
                    builder.withModulePath(modulePaths);
                }
                for (String module : modules) {
                    builder.withModule(module);
                }
                builder.withMainClass(mainClass);
                if(commandLineArguments.length != 0){
                    builder.withCommandLineArguments(commandLineArguments);
                }
                return builder.build().execute();
            }
        } catch (Exception e) {
            throw new ParameterResolutionException(e.getMessage());
        }
        return -1;
    }
}
