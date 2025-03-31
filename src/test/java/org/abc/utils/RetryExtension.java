package org.abc.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import java.util.logging.Logger;

public class RetryExtension implements TestExecutionExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(RetryExtension.class.getName());

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        // Define retry logic
        int retryCount = 3;  // Maximum retry attempts
        if (retryCount < 1) {
            throw throwable;  // If no retries left, throw exception
        }

        LOGGER.info("Retrying test " + context.getDisplayName() + " due to failure.");
        retryCount--;
        // Retry test execution
    }
}
