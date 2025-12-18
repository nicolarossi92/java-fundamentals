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
 * This class contains tests to validate rules about Garbage Collector's reclamation of
 * objects at runtime. Eligibility rules are shown.
 */
@DisplayName("C2.S6 - Destroying Objects rules")
@ExtendWith({JavaCompilerExtension.class, JavaRunnerExtension.class, TempDirectoryCallback.class})
public class C2S6DestroyingObjectsTest {

    /**
     * Garbage collection acts automatically and cannot be predicted when it will happen
     */
    @Test
    @DisplayName("Tracing eligibility for garbage collection means that we are looking out when the object is no longer reachable by the program")
    public void tracingEligibilityForGarbageCollection(
            @Compile(
                    classesToCompile = "TracingEligibilityForGarbageCollection.java",
                    mainClassPath = "c2/destroying_objects"
            ) Integer outputCompilation,
            @ExecuteJavaProgram(
                    mainClass = "TracingEligibilityForGarbageCollection"
            ) Integer outputExecution
    ) {
        Assertions.assertEquals(0, outputCompilation);
        Assertions.assertEquals(0, outputExecution);
    }

}
