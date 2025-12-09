package it.nicolarossi92.java.fundamentals.c2;

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
 * This class contains tests to validate the rule for correct definition of a constructor
 * used to initialize variables inside an object and other constructs to initialize
 * variables inside a class
 */
@DisplayName("C2.S1 - Initializing Objects rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C2S1InitializingObjectsTest {

    /**
     * This test ensures that correct definition of constructor
     * allow to initialize an object upon invocation with new
     */
    @Test
    @DisplayName("A constructor is defined in order to initialize an object")
    public void definingYourOwnConstructor(
            @Compile(
                    classesToCompile = "DefiningYourOwnConstructor.java",
                    mainClassPath = "c2/initializing_objects"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "DefiningYourOwnConstructor"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test ensures that field initialization is equally valid as constructor initialization.
     * Also, inside any field initialization any value can be read if it was previously initialized
     */
    @Test
    @DisplayName("Inside an initialization statement it is possible to read values from previous initialized values")
    public void readingAndWritingFields(
            @Compile(
                    classesToCompile = "ReadingAndWritingFields.java",
                    mainClassPath = "c2/initializing_objects"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "ReadingAndWritingFields"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test ensures that initialization blocks are an equally valid alternative to initialize field variables
     */
    @Test
    @DisplayName("Objects can also be initialized with initialization blocks, which are run before any code inside the constructor")
    public void initializationBlock(
            @Compile(
                    classesToCompile = "InitializationBlock.java",
                    mainClassPath = "c2/initializing_objects"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "InitializationBlock"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);

    }

    /**
     * Firstly, fields initialization statements and initialization blocks are run in the order
     * in which they appear inside the source code. After that, the code inside the invoked constructor is executed
     */
    @Test
    @DisplayName("The order of initialization follows certain rules")
    public void orderOfInitialization(
            @Compile(
                    classesToCompile = "OrderOfInitialization.java",
                    mainClassPath = "c2/initializing_objects"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "OrderOfInitialization"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }


}
