package org.example.utils.configs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBatisConfig {

    private static MyBatisConfig instance;
    private static String environment;

    private MyBatisConfig() {
        log.info("Read mybatis configuration");

        environment = ConfigManager.getInstance().getMybatisEnvironment();
    }

    public static String getMyBatisEnvironment() {
        log.info("Get mybatis configuration");
        if (instance == null) {
            instance = new MyBatisConfig();
        }
        return environment;
    }
}
