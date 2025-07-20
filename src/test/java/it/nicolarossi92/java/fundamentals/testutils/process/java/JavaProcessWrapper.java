package it.nicolarossi92.java.fundamentals.testutils.process.java;

import it.nicolarossi92.java.fundamentals.testutils.process.ProcessWrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Java process wrapper to execute either compilation or execution of java programs
 */
public class JavaProcessWrapper implements ProcessWrapper {

    private final static String SEPARARATOR = System.getProperty("os.name").contains("Windows") ? ";" : ":";
    private final Process process;
    private final String mainClassName;

    private JavaProcessWrapper(Process process, String mainClassName){
        this.process = process;
        this.mainClassName = mainClassName;
    }


    /**
     * Gets a {@link JavaProcessWrapperBuilder} used to build up a {@link Process}
     * to encapsulate logic to execute a Java program
     * @return {@link JavaProcessWrapperBuilder} the builder
     */
    public static JavaProcessWrapperBuilder builderJavaProcess(){
        return new JavaProcessWrapperBuilder();
    }


    /**
     * Gets a {@link JavacProcessWrapperBuilder} used to build up a {@link Process}
     * to encapsulate logic to execute Java compilation
     * @return {@link JavacProcessWrapperBuilder} the builder
     */
    public static JavacProcessWrapperBuilder builderJavacProcess(){
        return new JavacProcessWrapperBuilder();
    }

    /**
     * Execute the given process, either compilation or execution of Java programs
     * @return the exit code from either compilation or execution
     * @throws IOException if given files are not found
     * @throws InterruptedException if process gets interrupted
     */
    @Override
    public int execute() throws IOException, InterruptedException {
        BufferedReader runOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder runOutput = new StringBuilder();
        String line;
        while ((line = runOutputReader.readLine()) != null) {
            runOutput.append(line).append("\n");
        }

        BufferedReader runErrorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder runErrors = new StringBuilder();
        while ((line = runErrorReader.readLine()) != null) {
            runErrors.append(line).append("\n");
        }

        int runExitCode = process.waitFor();
        if (runExitCode != 0) {
            System.out.printf("Error during execution  of program (exit code " + runExitCode + "):");
            System.out.println(runErrors);
        } else {
            if(!runOutput.isEmpty()) {
                System.out.printf("Executed successfully file %s. Output:%n", mainClassName);
                System.out.println(runOutput);
            }
        }
        return runExitCode;
    }

    /**
     * Process builder for execution of Java code
     */
    public static class JavaProcessWrapperBuilder {


        private final List<String> commands = new ArrayList<>();
        private String mainClassName;

        private JavaProcessWrapperBuilder(){
            commands.add("java");
        }

        public JavaProcessWrapper build() throws IOException {
            return new JavaProcessWrapper(new ProcessBuilder()
                    .command(commands)
                    .start(), mainClassName);
        }


        /**
         * Specify the class paths used in executing the program
         * @param classPaths the class paths specified
         * @return {@link JavaProcessWrapperBuilder}
         */
        public JavaProcessWrapperBuilder withClassPath(String... classPaths){

            String classPathCommand = String.join(SEPARARATOR, classPaths);
            commands.add("-cp");
            commands.add(classPathCommand);
            return this;
        }


        /**
         * The module paths specified during execution
         * @param modulePaths the module path specified
         * @return {@link JavaProcessWrapperBuilder}
         */
        public JavaProcessWrapperBuilder withModulePath(String... modulePaths){
            String modulePathCommands = String.join(SEPARARATOR, modulePaths);
            commands.add("--module-path");
            commands.add(modulePathCommands);
            return this;
        }

        /**
         * Specify a module for execution
         * @param module the module specified
         * @return {@link JavaProcessWrapperBuilder}
         */
        public JavaProcessWrapperBuilder withModule(String module){
            commands.add("-module");
            commands.add(module);
            return this;
        }

        /**
         * Specify the main class to execute
         * @param mainClass the main class .class
         * @return {@link JavaProcessWrapperBuilder}
         */
        public JavaProcessWrapperBuilder withMainClass(String mainClass){
            commands.add(mainClass);
            this.mainClassName = mainClass;
            return this;
        }
    }

    /**
     * Process builder for compilation of Java programs
     */
    public static class JavacProcessWrapperBuilder {
        private final List<String> commands = new ArrayList<>();

        private JavacProcessWrapperBuilder(){
            commands.add("javac");
        }

        public JavaProcessWrapper build(String mainClassPath) throws IOException {
            return new JavaProcessWrapper(new ProcessBuilder()
                    .directory(new File(mainClassPath))
                    .command(commands)
                    .start(), null);
        }

        /**
         * Specify the output directory of compilation process
         * @param outputDir the output directory
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withOutputDir(String outputDir){
            commands.add("-d");
            commands.add(outputDir);
            return this;
        }

        /**
         * Specify the classPaths during compilation
         * @param classPaths the class paths to be specified
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withClassPath(String... classPaths){
            String classPathCommand = String.join(SEPARARATOR, classPaths);
            commands.add("-cp");
            commands.add(classPathCommand);
            return this;
        }


        /**
         * Specify a list of module paths to include during compilation
         * @param modulePaths the paths of modules
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withModulePath(String... modulePaths){
            String modulePathCommands = String.join(SEPARARATOR, modulePaths);
            commands.add("--module-path");
            commands.add(modulePathCommands);
            return this;
        }

        /**
         * Add a module during compilation
         * @param module the module to add
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withModule(String module){
            commands.add("-module");
            commands.add(module);
            return this;
        }

        /**
         * Add the sources to compile in the process
         * @param sources .java files to compile
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withSources(String... sources){
            String sourcesJoined = String.join(SEPARARATOR, sources);
            commands.add(sourcesJoined);
            return this;
        }


        /**
         * Add source paths for the given compilation process
         * @param sourcePaths the paths of the sources
         * @return {@link JavacProcessWrapperBuilder}
         */
        public JavacProcessWrapperBuilder withSourcePath(String... sourcePaths){
            String sourcePathCommands = String.join(SEPARARATOR, sourcePaths);
            commands.add("-sourcepath");
            commands.add(sourcePathCommands);
            return this;
        }
    }
}
