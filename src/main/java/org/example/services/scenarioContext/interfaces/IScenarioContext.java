package org.example.services.scenarioContext.interfaces;

import com.codeborne.selenide.SelenideElement;
import org.example.dataManager.enums.Pages;
import org.example.pages.AbstractPageObject;

import java.util.HashMap;
import java.util.Map;

public interface IScenarioContext {
    Map<ScenarioKeys, Object> data = new HashMap<>();
    void save(ScenarioKeys scenarioKeys, Object value);

    <T> T getData(ScenarioKeys scenarioKeys);

    SelenideElement getWebElementByName(String elementName);

    SelenideElement getWebElementFromMap(String elementName, String type);

    AbstractPageObject getPageObjectByPageName(Pages page);
}
