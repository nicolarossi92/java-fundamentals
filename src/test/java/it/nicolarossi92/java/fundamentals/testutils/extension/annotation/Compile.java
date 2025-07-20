package it.nicolarossi92.java.fundamentals.testutils.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Compile {
    String[] classesToCompile();
    String[] classPath() default {};
    String mainClassPath();
    String outDir() default "";
    String[] modules() default {};
    String[] sourcePath() default {};
    String[] modulePath() default {};
}
