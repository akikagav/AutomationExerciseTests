package com.automationExercises.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(PropertiesLoader.class);
    private static final String PROPERTIES_FILE_PATH = "src/resources/config.properties";

    /**
     * Loads a specific property value from a properties file.
     */
    public static String loadProperty(String propertyName) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Error loading properties file: " + e.getMessage());
        }
        return properties.getProperty(propertyName, "Property not found");
    }
}
