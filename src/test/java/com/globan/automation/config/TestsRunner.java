package com.globan.automation.config;

import lombok.Getter;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestsRunner {


    private final Properties PROPERTIES = new Properties();

    @Getter
    private static String baseURL;

    @BeforeSuite
    public void setUpEnvironment() throws IOException {
        loadProperties();
        baseURL = PROPERTIES.getProperty("url.base");
    }

    private void loadProperties() throws IOException {
        String PROPERTIES_FILE = "src/test/resources/config.properties";
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE)) {
            PROPERTIES.load(fileInputStream);
        }
    }
}
