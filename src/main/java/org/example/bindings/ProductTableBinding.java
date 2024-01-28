package org.example.bindings;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mk_latn.No;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.wrappers.ProductTableWrapper;

import static com.codeborne.selenide.Condition.not;
import static com.google.common.base.CharMatcher.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
@NoArgsConstructor
public class ProductTableBinding {

    ProductTableWrapper productTable = new ProductTableWrapper();


    @Then("^The (.*) are (listed|not listed) in the product table$")
    @Step("Verify that {productName} is listed in the table")
    public void verifyProductList(String productName, String listStatus) {
//        boolean listed = productTable
//                .isTableContainsProduct(productName);
//        boolean expectedResult;
//        expectedResult = listStatus.equals("listed");
//
//        assertThat(String.format("The %s product should be %s in the Product table", productName, listStatus),
//                listed,
//                equalTo(expectedResult));

        Condition condition = listStatus.equals("listed") ? Condition.visible : not(Condition.visible);
        productTable
                .ifProductIsVisible(productName, condition);
    }


    @When("User deletes {string} from the product table")
    @Step("Click delete button for the {productName} product")
    public void deleteProductFromProductTable(String productName) {
        productTable
                .clickDeleteButton(productName);
    }

}
