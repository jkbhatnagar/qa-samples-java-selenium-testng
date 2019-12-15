package org.example.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileService {
    private static ConfigFileService instance = new ConfigFileService();
    private Properties properties;

    private ConfigFileService() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (Exception e) {

        }
    }

    public static ConfigFileService getConfigs() {
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
