package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]//ol/li")
    private WebElement messageLabel;

    @Step("Type into Email Field: {email}")
    public LoginPage typeIntoEmailField(String email) {
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys(email);
        log().info("Typed into Email Field: {}", email);
        return this;
    }

    @Step("Type into Password Field: {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field: {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public LoginPage ClickOnSignInButton() {
        signInButton.click();
        log().info("Clicked on Sign in Button");
        return this;
    }

    @Step("Assert that warning message: {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message: {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }
}
