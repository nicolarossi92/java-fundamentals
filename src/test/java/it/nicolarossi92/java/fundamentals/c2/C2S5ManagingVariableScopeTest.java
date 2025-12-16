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
 * This class contains tests to validate rules regarding the scope of local variables
 */
@DisplayName("C2.S5 - Managing Variable Scope rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C2S5ManagingVariableScopeTest {

    /**
     * Variables declared at the top of a method (not in an enclosing smaller scope) or constructor
     * and method/constructor parameters have their scope that lasts until the end of the declaration
     */
    @Test
    @DisplayName("Method parameter and constructor parameter have a scope limited to the entire method/constructor.")
    public void scopeInsideAMethod(
            @Compile(
                    classesToCompile = "ScopeInsideAMethod.java",
                    mainClassPath = "c2/managing_variable_scope"
            ) Integer outputCompilation
    ) {
        Assertions.assertEquals(0, outputCompilation);
    }

    /**
     * Variables declared in an enclosing smaller scope cannot be accessed from outside and the compiler
     * will complain
     */
    @Test
    @DisplayName("Variables inside a smaller scope cannot be accessed outside their scope")
    public void smallerScopeAccess(
            @Compile(
                    classesToCompile = "SmallerScopeAccess.java",
                    mainClassPath = "c2/managing_variable_scope"
            ) Integer outputCompilation
    ) {
        Assertions.assertNotEquals(0, outputCompilation);
    }

    /**
     * Variables can access other variables outside their scope in the larger limiting and enclosing scope
     */
    @Test
    @DisplayName("Variables can access other variables from larger limiting scopes")
    public void largerScopeAccess(
            @Compile(
                    classesToCompile = "LargerScopeAccess.java",
                    mainClassPath = "c2/managing_variable_scope"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "LargerScopeAccess"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }
}
