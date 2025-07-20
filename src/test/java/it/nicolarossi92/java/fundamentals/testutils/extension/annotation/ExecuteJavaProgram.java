package it.nicolarossi92.java.fundamentals.testutils.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteJavaProgram {

    String mainClass();
    String[] classPath() default {};
    String[] modulePath() default {};
    String[] modules() default {};
    String[] commandLineArguments() default {};
}
