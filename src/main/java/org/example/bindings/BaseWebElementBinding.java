package org.example.bindings;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class BaseWebElementBinding {

    @Given("User clicks by {selenideElement}")
    @Step("Click by {button} button")
    public void clickByButton(SelenideElement button){
        button
                .shouldBe(Condition.visible)
                .click();
    }

    @Given("User double clicks by {selenideElement}")
    @Step("Double click by {button} button")
    public void doubleClickByButton(SelenideElement button){
        button
                .shouldBe(Condition.visible)
                .doubleClick();
    }

    @Given("User hovers mouse on {selenideElement}")
    @Step("Hover mouse on {element} element")
    public void hoverOnButton(SelenideElement element){
        element
                .shouldBe(Condition.visible)
                .hover();
    }

    @Given("User enters {string} in to {selenideElement}")
    @Step("Enter {value} in to the {input} input")
    public void enterValueIntoTheInput(String value, SelenideElement input){
        input
                .shouldBe(Condition.visible)
                .sendKeys(value);
    }
}
