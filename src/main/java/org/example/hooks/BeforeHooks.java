package org.example.hooks;

import io.cucumber.java.BeforeAll;
import org.example.services.scenarioContext.ScenarioContext;
import org.example.services.scenarioContext.interfaces.IScenarioContext;
import org.example.utils.configs.SelenideConfig;

public class BeforeHooks {

    public static IScenarioContext context;

    @BeforeAll
    public static void setUp() {
        System.out.println("SET UP METHOD");
        context = ScenarioContext.getInstance();
        SelenideConfig.getInstance();
    }
}
