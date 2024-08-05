package com.automationExercises.util;

import com.automationExercises.model.SearchValue;
import com.automationExercises.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    private static final Logger logger = LogManager.getLogger(TestData.class);

    private static final String CSV_FILES_PATH = "src/resources/csv/";

    /**
     * Reads user information from a JSON file and converts it into a 2D Object array format
     */
    public static Object[][] getUserInfo() {
        String jsonString = JsonReader.readJson("user.json");
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<User>>() {}.getType();
        List<User> userList = gson.fromJson(jsonString, userListType);
        Object[][] userData = new Object[userList.size()][1];
        for (int i = 0; i < userList.size(); i++) {
            userData[i][0] = userList.get(i);
        }
        return userData;
    }

    /**
     * Reads search values from a CSV file and converts them into a 2D Object array format
     */
    public static Object[][] getSearchValues() {
        List<SearchValue> searchValues = new ArrayList<>();
        try (CSVParser parser = new CSVParser(
                new FileReader(CSV_FILES_PATH + "searchValues.csv"), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : parser) {
                SearchValue value = new SearchValue(record.get("searchValue"));
                searchValues.add(value);
            }
        } catch (IOException e) {
            logger.error("Error loading CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        Object[][] searchValuesData = new Object[searchValues.size()][1];
        for (int i = 0; i < searchValues.size(); i++) {
            searchValuesData[i][0] = searchValues.get(i);
        }
        return searchValuesData;
    }


}
