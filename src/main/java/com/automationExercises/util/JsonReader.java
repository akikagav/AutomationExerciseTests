package com.automationExercises.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    private static final String JSON_FILES_PATH = "src/resources/json/";
    private static final Logger logger = LogManager.getLogger(JsonReader.class);


    /**
     * Reads the content of a JSON file and returns it as a string.
     */
    public static String readJson(String fileName) {
        String jsonString = "";
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(JSON_FILES_PATH + fileName)));
        } catch (IOException e) {
            logger.error("Error loading JSON file: " + JSON_FILES_PATH + fileName + ". " + e.getMessage());
            e.printStackTrace();
        }
        return jsonString;
    }

}
