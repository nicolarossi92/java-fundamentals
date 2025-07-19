package it.nicolarossi92.java.fundamentals.testutils.process;

import java.io.IOException;

/**
 * Process wrapper used to encapsulate logic for execution of a given process
 */
public interface ProcessWrapper {
    int execute() throws IOException, InterruptedException;
}
