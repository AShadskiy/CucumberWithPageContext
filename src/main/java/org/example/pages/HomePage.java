package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage implements AbstractPageObject {

    String inputBaseSelector = "//input[@id='%s']";

    SelenideElement productTable = $(".table.table-hover");

    Map<String, SelenideElement> input = new HashMap<>() {{
        put("nameInput", $x(String.format(inputBaseSelector, "newProductTitle")));
        put("priceInput", $x(String.format(inputBaseSelector, "newProductPrice")));
        put("productCategoryInput", $x(String.format(inputBaseSelector, "newProductCategory")));
    }};

    Map<String, SelenideElement> button = new HashMap<>() {{
        put("saveButton", $x("//button[@type='submit']"));
    }};

    @Override
    public boolean isInitialized() {
        boolean value = false;
        try {
            value = productTable
                    .shouldBe(Condition.visible, Duration.ofSeconds(5))
                    .isDisplayed();
        } catch (Exception e) {
            System.out.println("Page is not initialized");
        }
        return value;
    }
}
