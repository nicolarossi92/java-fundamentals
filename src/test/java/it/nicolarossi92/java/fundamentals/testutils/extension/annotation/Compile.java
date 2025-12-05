package it.nicolarossi92.java.fundamentals.testutils.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation used to trigger compilation of Java source files
 * as part of a parameterized JUnit 5 test.
 * Each attribute describes how the compilation process should be configured:
 * <ul>
 *   <li>{@code classesToCompile}: .java files to compile</li>
 *   <li>{@code sourcePath}: directories where source files are located</li>
 *   <li>{@code classPath}: additional classpath entries during compilation</li>
 *   <li>{@code modulePath}: module path entries (for JPMS)</li>
 *   <li>{@code modules}: modules to compile against</li>
 *   <li>{@code mainClassPath}: base directory used as working directory for the compilation process</li>
 *   <li>{@code outDir}: optional custom output directory for compiled classes</li>
 * </ul>
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Compile {
    String[] classesToCompile();
    String[] classPath() default {};
    String mainClassPath();
    String[] modules() default {};
    String[] sourcePath() default {};
    String[] modulePath() default {};
}
