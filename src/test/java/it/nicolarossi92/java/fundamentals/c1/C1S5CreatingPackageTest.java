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
 * This class contains tests that validates the rules for
 * logical groupings of classes under package and import statements
 */
@DisplayName("C1.S5 - Creating Package rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C1S5CreatingPackageTest {

    /**
     * This test ensures that grouping classes under packages
     * and compiling them correctly, provides a logical grouping of classes
     * which can be accessed by other classes with import statements
     */
    @Test
    @DisplayName("Classes can be grouped under packages with a package statement")
    public void groupingUnderPackages(
            @Compile(
                    classesToCompile = {"packagea/ClassPackageA.java", "packageb/ClassPackageB.java"},
                    mainClassPath = "c1/creating_packages/grouping_under_packages"
            ) Integer outputCompilation,

            @ExecuteJavaProgram(
                    mainClass = "packageb.ClassPackageB"
            ) Integer outputExecution
    ){
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);

    }
}
