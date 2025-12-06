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
 * This class contains tests to validate rules regarding imports
 * and import conflicts
 */
@DisplayName("C1.S4 - Understanding Imports rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C1S4UnderstandingImportsTest {

    /**
     * Test to ensure that a class external to java.lang package needs an import
     * in order to use that same class inside a program. This demonstrates
     * that import statement are necessary for compilation
     */
    @Test
    @DisplayName("Imports tell to the compiler where to find particular classes. Without them, it won't compile")
    public void withoutImportsMustNotCompile(
        @Compile(
                mainClassPath = "c1/understanding_imports",
                classesToCompile = "WithoutImportsMustNotCompile.java"
        ) Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Test to ensure that a class outside java.lang package, if imported correctly with
     * the proper statement, will compile successfully
     */
    @Test
    @DisplayName("Package act as address and imports tell the compiler where to find the given class")
    public void withImportsMustCompile(
            @Compile(
                    classesToCompile = "WithImportsMustCompile.java",
                    mainClassPath = "c1/understanding_imports"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Test ensure that if two classes with the same name are imported with
     * import statement, the compiler will output an error since it cannot
     * possibly discriminate which class to use as a default
     */
    @Test
    @DisplayName("If two classes are imported with the same name, the compilation will not be successful")
    public void twoClassesSameNameMustNotCompile(
            @Compile(
                    classesToCompile = "TwoClassesSameNameMustNotCompile.java",
                    mainClassPath = "c1/understanding_imports"
            ) Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * This test ensures that if two classes are imported, one of which through wildcard and the
     * other through an explicit import statement, the program will compile.
     * This demonstrates that explicit imports override wildcard imports
     */
    @Test
    @DisplayName("If two classes with same name are imported, but only one with explicit import, then it will compile")
    public void explicitImportOverridesWildcardImport(
            @Compile(
                    classesToCompile = "ExplicitImportOverridesWildcardImport.java",
                    mainClassPath = "c1/understanding_imports"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * This test ensures that two classes with same name can be used inside the same
     * program, if at least one of them uses a fully qualified name, which
     * makes the import statement not necessary
     */
    @Test
    @DisplayName("If one class is imported and the other is used with fully qualified name, it will compile")
    public void fullyQualifiedNameOverImport(
            @Compile(
                    classesToCompile = "FullyQualifiedNameOverImport.java",
                    mainClassPath = "c1/understanding_imports"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }
}
