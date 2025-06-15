package com.globan.automation.config;

import lombok.Getter;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Base test runner class that sets up the environment for API tests.
 * Loads configuration properties and initializes the base URL for API requests.
 */

public class TestsRunner {

    /**
     * Properties object containing configuration loaded from file.
     */
    private final Properties PROPERTIES = new Properties();

    /**
     * Base URL for API requests, loaded from configuration.
     */
    @Getter
    private static String baseURL;


    /**
     * Initializes the test environment before the test suite runs.
     * Loads properties and sets the base URL.
     *
     * @throws IOException if the properties file cannot be read
     */
    @BeforeSuite
    public void setUpEnvironment() throws IOException {
        loadProperties();
        baseURL = PROPERTIES.getProperty("url.base");
    }

    /**
     * Loads configuration properties from the properties file.
     *
     * @throws IOException if the properties file cannot be read
     */
    private void loadProperties() throws IOException {
        String PROPERTIES_FILE = "src/test/resources/config.properties";
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE)) {
            PROPERTIES.load(fileInputStream);
        }
    }
}
