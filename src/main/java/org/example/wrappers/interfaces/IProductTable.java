package org.example.wrappers.interfaces;

import com.codeborne.selenide.SelenideElement;

public interface IProductTable {

    void clickDeleteButton(String productName);

    boolean isTableContainsProduct(String productName);
    SelenideElement getRowByProductName(String productName);
}
