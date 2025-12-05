package it.nicolarossi92.java.fundamentals.c1;

import it.nicolarossi92.java.fundamentals.testutils.extension.JavaCompilerExtension;
import it.nicolarossi92.java.fundamentals.testutils.extension.JavaRunnerExtension;
import it.nicolarossi92.java.fundamentals.testutils.extension.TempDirectoryCallback;
import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.Compile;
import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.ExecuteJavaProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the argument passing
 * to the main method
 */
@DisplayName("C1.S2 – Writing Main Method rules")
@ExtendWith({TempDirectoryCallback.class, JavaCompilerExtension.class, JavaRunnerExtension.class})
public class C1S2WritingMainMethodTest {

    /**
     * This test ensures that the arguments passed are effectively
     * used by the program itself
     */
    @Test
    @DisplayName("Arguments can be passed to the main method, which acts as a gateway to the code")
    void passArgumentsToMainMethod(
            @Compile(
                    mainClassPath = "c1/writing_main_method",
                    classesToCompile = "PassArgumentsToMainMethod.java"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "PassArgumentsToMainMethod",
                    commandLineArguments = "Hello!"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
