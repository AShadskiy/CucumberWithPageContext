package org.example.wrappers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.example.wrappers.interfaces.IProductTable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;

public class ProductTableWrapper implements IProductTable {

    String deleteButton = ".//button[contains(text(),'Удалить товар')]";
    String productRow = "//td[contains(text(),'%s')]/..";

    @Override
    public SelenideElement getRowByProductName(String productName) {
        return $x(String.format(productRow, productName))
                .shouldBe(Condition.visible);
    }

    @Override
    public void clickDeleteButton(String productName) {
        getRowByProductName(productName)
                .shouldBe(Condition.visible)
                .find(By.xpath(deleteButton))
                .shouldBe(Condition.visible)
                .click();
    }

    @Override
    public boolean isTableContainsProduct(String productName) {
        return $x(String.format(productRow, productName)).isDisplayed();
    }
}
