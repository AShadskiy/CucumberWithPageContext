package org.example.services.transformers;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ParameterType;
import org.example.dataManager.enums.Pages;
import org.example.helpers.StringHelper;

import static org.example.hooks.BeforeHooks.context;

public class StepTransformer {

    @ParameterType(".*")
    public SelenideElement selenideElement(String glue) {
        String elementType = glue.substring(glue.lastIndexOf(" ") + 1);
        String elementName = StringHelper.getCamelCaseString(glue);

        return context.getWebElementFromMap(elementName, elementType);
    }

    @ParameterType(".*")
    public Pages page(String glue) {
        return Pages.valueOf(StringHelper.getScreamingSnakeCaseString(glue));
    }
}
