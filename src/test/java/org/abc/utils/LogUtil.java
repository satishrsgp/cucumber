package org.abc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

    // Create a logger instance for each class
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    // Method to log info messages
    public static void info(String message) {
        logger.info(message);
    }

    // Method to log debug messages
    public static void debug(String message) {
        logger.debug(message);
    }

    // Method to log error messages
    public static void error(String message) {
        logger.error(message);
    }

    // Method to log warnings
    public static void warn(String message) {
        logger.warn(message);
    }
}
