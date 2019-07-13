package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class PrintedDressProductPage extends BasePage {

    @FindBy(id = "quantity_wanted" )
    private WebElement quantityTextInputField;

    @FindBy(xpath = "//a[@class=\"btn btn-default button-minus product_quantity_down\"]")
    private WebElement quantityDownButton;

    @FindBy(xpath = "//a[@class=\"btn btn-default button-plus product_quantity_up\"]")
    private WebElement quantityUpButton;

    @Step("Click on quantity up button")
    private PrintedDressProductPage clickOnQuantityUpButton() {
        WaitForElement.waitUntilElementClickable(quantityUpButton);
        quantityUpButton.click();
        log().info("Clicked on Quantity Up Button");
        return this;
    }

    @Step("Click on quantity down button")
    private PrintedDressProductPage clickOnQuantityDownButton() {
        WaitForElement.waitUntilElementClickable(quantityDownButton);
        quantityDownButton.click();
        log().info("Clicked on Quantity Down Button");
        return this;
    }

    @Step("Type into quantity text input field: {message}")
    public PrintedDressProductPage typeIntoMessageArea(String quantityWanted) {
        quantityTextInputField.clear();
        quantityTextInputField.sendKeys(quantityWanted);
        log().info("Typed: {} into quantity wanted text input field", quantityWanted);
        return this;
    }

    @Step("Assert that quantity field value initially equals: 1" +
            " and equals: 2 after clicking Up Button")
    public PrintedDressProductPage assertThatValueChangedAfterUpButtonClicked() {
        AssertWebElement.assertThat(quantityTextInputField).hasValue("1");
        this.clickOnQuantityUpButton();
        AssertWebElement.assertThat(quantityTextInputField).hasValue("2");
        return this;
    }
}
