package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import static org.testng.Assert.assertEquals;

public class ContactPage extends BasePage {

    @FindBy(id = "id_contact")
    private WebElement subjectDropdown;
    Select subjectHeadingDropdown = new Select(subjectDropdown);

    @FindBy(id = "email")
    private WebElement emailAddressField;

    @FindBy(id = "id_order")
    private WebElement orderReferenceField;

    @FindBy(id = "message")
    private WebElement messageArea;

    @FindBy(id = "submitMessage")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    private WebElement alert;

    @Step("Type into Email Address Field: {email}")
    public ContactPage typeIntoEmailAddressField(String email) {
        WaitForElement.waitUntilElementIsVisible(emailAddressField);
        emailAddressField.sendKeys(email);
        log().info("Typed into Email Address Field: {}", email);
        return this;
    }

    @Step("Type into Order Reference Field: {orderReference}")
    public ContactPage typeIntoOrderReferenceField(String orderReference) {
        WaitForElement.waitUntilElementIsVisible(orderReferenceField);
        orderReferenceField.sendKeys(orderReference);
        log().info("Typed into Order Reference Field: {}", orderReference);
        return this;
    }

    @Step("Type into message area: {message}")
    public ContactPage typeIntoMessageArea(String message) {
        messageArea.clear();
        messageArea.sendKeys(message);
        log().info("Typed into message area: {}", message);
        return this;
    }

    @Step("Click on Send Button")
    public ContactPage clickOnSendMessageButton() {
        sendMessageButton.click();
        log().info("Clicked on Send Button");
        return this;
    }

    @Step("Choose option from dropdown")
    public ContactPage chooseOptionFromDropdown(String number) {
        log().info("Select option number: {} is displayed", number);
        subjectHeadingDropdown.selectByValue(number);
        return this;
    }

    @Step("Assert that text from dropdown element number: {number} is equal to: {optionText}")
    //@Parameters({"number", "optionText"})
    public ContactPage assertThatDropdownOptionTextIsProper(String number, String optionText) {
        log().info("Checking if option: {} is displayed", optionText);
        subjectHeadingDropdown.selectByValue(number);
        String selectedOption = subjectHeadingDropdown.getFirstSelectedOption().getText();
        assertEquals(selectedOption, optionText);
        return this;
    }

    @Step("Assert that message {message} is displayed")
    public ContactPage assertThatAlertIsDisplayed(String message) {
        log().info("Checking if message: {} is displayed", message);
        WaitForElement.waitUntilElementIsVisible(alert);
        AssertWebElement.assertThat(alert).isDisplayed().hasText(message);
        return this;
    }

}
