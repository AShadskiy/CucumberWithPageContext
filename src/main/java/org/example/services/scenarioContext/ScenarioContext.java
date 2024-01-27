package org.example.services.scenarioContext;

import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.dataManager.enums.ContextKeys;
import org.example.dataManager.enums.Pages;
import org.example.exceptions.PageNotFoundException;
import org.example.pages.AbstractPageObject;
import org.example.services.scenarioContext.interfaces.IScenarioContext;
import org.example.services.scenarioContext.interfaces.ScenarioKeys;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.example.hooks.BeforeHooks.context;
import static org.example.utils.configs.PathConfig.PAGES_PATH;

@Slf4j
public class ScenarioContext implements IScenarioContext {

    private static ScenarioContext instance;

    private final Map<ScenarioKeys, Object> contextData = new HashMap<>();

    @Override
    public void save(ScenarioKeys scenarioKeys, Object value) {
        contextData.put(scenarioKeys, value);
    }

    @Override
    public <T> T getData(ScenarioKeys scenarioKeys) {
        return (T) contextData.get(scenarioKeys);
    }

    @Override
    public SelenideElement getWebElementByName(String elementName) {
        SelenideElement webElement = null;
        AbstractPageObject page = context.getData(ContextKeys.CURRENT_PAGE);
        Class<? extends AbstractPageObject> currentScope = page.getClass();
        Field[] fields = currentScope.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType() == SelenideElement.class) {
                field.setAccessible(true);
                if (field.getName().equals(elementName)) {
                    try {
                        webElement = (SelenideElement) field.get(page);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (webElement == null) {
//            throw new WebElementNotFoundException(elementName + " web element wasn't found in the " + page.getPageName() + " page");
        }
        return webElement;
    }

    @Override
    public SelenideElement getWebElementFromMap(String elementName, String type) {
        SelenideElement webElement = null;
        AbstractPageObject page = context.getData(ContextKeys.CURRENT_PAGE);
        Class<? extends AbstractPageObject> currentScope = page.getClass();
        Field[] fields = currentScope.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType() == Map.class) {
                field.setAccessible(true);
                if (field.getName().equals(type)) {
                    try {
                        Map<String, SelenideElement> elementsMap = (Map<String, SelenideElement>) field.get(page);
                        webElement = elementsMap.get(elementName);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (webElement == null) {
//            throw new WebElementNotFoundException(elementName + " web element wasn't found in the " + page.getPageName() + " page with alias " + type);
        }
        return webElement;
    }

    @Override
    @SneakyThrows
    public AbstractPageObject getPageObjectByPageName(Pages page) {
        Class<?> c = null;
        Constructor<?> cons = null;
        AbstractPageObject currentPage = null;

        String path = PAGES_PATH + page.getPageName();

        try {
            c = Class.forName(path);
            cons = c.getConstructor();
            currentPage = (AbstractPageObject) cons.newInstance();
        } catch (ClassNotFoundException e) {
            throw new PageNotFoundException(page.getPageName() + " page not found in the folder - " + path);
        } catch (NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(page.getPageName() + " page object wasn't created because ", e);
        }
        return currentPage;
    }

    public static ScenarioContext getInstance() {
        log.info("Initialize scenario context");
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }
}
