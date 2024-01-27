package org.example.utils.configs;

import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.ConfigManagerException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class ConfigManager {

    private static final String ENV = System.getProperty("APP-ENV", "local");
    private static final String MAIN_CONFIG_PATH = "env-config/%s/main-config.properties";
    public static final String CURRENT_MAIN_CONFIG = String.format(MAIN_CONFIG_PATH, ENV);
    private static final String USER_CONFIG_PATH = "src/main/resources/env-config/%s/user-data.json";
    public static final String CURRENT_USER_CONFIG = String.format(USER_CONFIG_PATH, ENV);
    private static ConfigManager instance;
    private final Properties properties = new Properties();

    private ConfigManager() {
        log.info("Read main configuration");
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream(CURRENT_MAIN_CONFIG);
            properties.load(stream);
        } catch (IOException ioException) {
            throw new ConfigManagerException(ioException);
        }
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getBaseUrl() {
        return properties.getProperty("base_url");
    }

    public String getPagesPath() {
        return properties.getProperty("pages_path");
    }

    public String getSelenideRemoteServer() {
        return properties.getProperty("selenide_remoteServer");
    }

    public String getSelenideTimeout() {
        return properties.getProperty("selenide_timeout");
    }

    public String getSelenideBrowserSize() {
        return properties.getProperty("selenide_browserSize");
    }

    public String getSelenideRemote() {
        return properties.getProperty("selenide_remote");
    }

    public String getMybatisEnvironment() {
        return properties.getProperty("mybatis_environment");
    }

}
