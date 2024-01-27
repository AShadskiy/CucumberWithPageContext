package org.example.bindings;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.example.dataManager.enums.ContextKeys;
import org.example.dataManager.enums.Pages;
import org.example.pages.AbstractPageObject;

import static org.example.hooks.BeforeHooks.context;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UrlBinding {

    @Given("User opened {page}")
    @Step("Open {page} page")
    public void openPage(Pages page){
        Selenide.open(page.getPageUrl());
        AbstractPageObject pageContext = context.getPageObjectByPageName(page);
        assertThat("Page object " + page.name() + " isn't initialized",
                pageContext.isInitialized(), is(true));
        context.save(ContextKeys.CURRENT_PAGE, pageContext);
    }
}
