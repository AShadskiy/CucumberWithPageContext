package org.example.utils.configs;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

@Slf4j
public class SelenideConfig {

    private static SelenideConfig instance;

    private SelenideConfig() {
        log.info("Read web driver configuration");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.browserSize = ConfigManager.getInstance().getSelenideBrowserSize();
        Configuration.timeout = Long.parseLong(ConfigManager.getInstance().getSelenideTimeout());
        Configuration.browser = "EDGE";
        Configuration.startMaximized = true;
        if (Boolean.parseBoolean(ConfigManager.getInstance().getSelenideRemote())) {
            Configuration.remote = ConfigManager.getInstance().getSelenideRemoteServer();
        }
    }

    public static SelenideConfig getInstance() {
        log.info("Get web driver configuration");
        if (instance == null) {
            instance = new SelenideConfig();
        }
        return instance;
    }

}
