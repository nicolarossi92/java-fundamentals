package it.nicolarossi92.java.fundamentals.c1;

import it.nicolarossi92.java.fundamentals.testutils.extension.JavaCompilerExtension;
import it.nicolarossi92.java.fundamentals.testutils.extension.TempDirectoryCallback;
import it.nicolarossi92.java.fundamentals.testutils.extension.annotation.Compile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * This class contains tests to validate the rules related to class definitions
 * in Java files, specifically regarding public and non-public classes.
 */
@ExtendWith({TempDirectoryCallback.class, JavaCompilerExtension.class})
public class C1S1ClassesVsFilesTest {

    /**
     * Test to ensure that two public classes cannot be in the same file.
     * According to Java rules, only one public class is allowed per file,
     * and its name must match the file name.
     * This test verifies that the compilation fails when more than one public
     * class is present in a single file.
     */
    @Test
    @DisplayName("Two public classes cannot be in the same file")
    public void twoPublicClassesConflict(
        @Compile(
                mainClassPath = "c1/classes_vs_files",
                classesToCompile = "TwoPublicClass.java"
        ) Integer outputCompilation
    ){
        Assertions.assertNotEquals(0, outputCompilation);
    }

}
