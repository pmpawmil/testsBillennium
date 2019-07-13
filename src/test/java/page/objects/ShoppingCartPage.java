package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//p[@class = \"alert alert-warning\"]")
    private WebElement alertMessage;

    @FindBy(xpath = "//td[@class=\"cart_delete text-center\"]//a")
    private WebElement trashDeleteItem;

    @Step("Assert that message: {message} is displayed")
    public ShoppingCartPage assertThatAlertIsDisplayed(String message) {
        log().info("Checking if message: {} is displayed", message);
        WaitForElement.waitUntilElementIsVisible(alertMessage);
        AssertWebElement.assertThat(alertMessage).isDisplayed().hasText(message);
        return this;
    }


}
