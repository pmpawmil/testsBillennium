package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import tests.PrintedDressProductPage;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(xpath = "//div[@class = \"shopping_cart\"]/a")
    private WebElement shoppingCartLink;

    @FindBy(css = "img[title=\"Printed Dress\"]")
    private WebElement printedDressItem;

    private final String messageFromModalXPath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2";

    private final String addToCartButtonXPath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-tablet-line " +
            "first-item-of-mobile-line hovered']//span[contains(text(),'Add to cart')]";

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementClickable(signInLink);
        signInLink.click();
        log().info("Clicked on Sign in Link");
        return new LoginPage();
    }

    @Step("Click on Shopping Cart Link")
    public ShoppingCartPage clickOnShoppingCartLink() {
        WaitForElement.waitUntilElementClickable(shoppingCartLink);
        shoppingCartLink.click();
        log().info("Clicked on Shopping Cart Link");
        return new ShoppingCartPage();
    }

    @Step("Click on Printed Dress image")
    public PrintedDressProductPage clickOnPrintedDressImage() {
        WaitForElement.waitUntilElementClickable(printedDressItem);
        printedDressItem.click();
        log().info("Clicked on Printed Dress image");
        return new PrintedDressProductPage();
    }

    @Step("Add item to Shopping Cart")
    public TopMenuPage addItemToShoppingCart() {
        WaitForElement.waitUntilElementIsVisible(printedDressItem);
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveToElement(printedDressItem).build().perform();
        log().info("Moved to Printed Dress Product image area");
        WebElement addToCartButton = DriverManager.getWebDriver()
                .findElement(By.xpath(addToCartButtonXPath));
        WaitForElement.waitUntilElementClickable(addToCartButton);
        addToCartButton.click();
        log().info("Clicked on Add To Cart button");
        return this;
    }

    @Step("Assert that message: {message} is displayed")
    public TopMenuPage assertThatSuccessfullyAddedProductMessageIsDisplayed(String message) {
        log().info("Checking if message: {} is displayed", message);
        WebElement messageFromModal = DriverManager.getWebDriver().
                findElement(By.xpath(messageFromModalXPath));
        WaitForElement.waitUntilElementIsVisible(messageFromModal);
        AssertWebElement.assertThat(messageFromModal).isDisplayed().hasText(message);
        return this;
    }
}
