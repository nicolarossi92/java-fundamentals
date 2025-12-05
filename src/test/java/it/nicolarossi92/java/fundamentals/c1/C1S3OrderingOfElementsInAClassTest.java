package it.nicolarossi92.java.fundamentals.c1;

import it.nicolarossi92.java.fundamentals.testutils.extension.JavaCompilerExtension;
import it.nicolarossi92.java.fundamentals.testutils.extension.JavaRunnerExtension;
import it.nicolarossi92.java.fundamentals.testutils.extension.TempDirectoryCallback;
import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.Compile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains test to ensure that correct order
 * of elements inside a class is needed in order to compile
 */
@DisplayName("C1.S3 - Ordering Of Elements in a Class rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C1S3OrderingOfElementsInAClassTest {

    /**
     * The correct order of elements inside a class, where a package is
     * optional, imports are optional if no classes are imported
     * and a class definition is mandatory. (PIC - package, imports, Class)
     */
    @Test
    @DisplayName("Correct order of element in a class is PIC (Package, Imports, Class)")
    void correctOrderOfElementsTest(
            @Compile(
                    classesToCompile = "CorrectOrderInAClass.java",
                    mainClassPath = "c1/ordering_of_elements_in_a_class"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Incorrect order won't compile
     */
    @Test
    @DisplayName("Incorrect order of elements in a class must not compile")
    public void incorrectOrderOfElementsMustNotCompileTest(
            @Compile(
                    classesToCompile = "IncorrectOrderOfElementsMustNotCompile.java",
                    mainClassPath = "c1/ordering_of_elements_in_a_class"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(1, outputCompilation);
    }
}
