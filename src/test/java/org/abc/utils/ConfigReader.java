package org.abc.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseURL");
    }

    public static String getEnvironment() {
        return properties.getProperty("environment");
    }
}
