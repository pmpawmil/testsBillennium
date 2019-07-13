package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

//Klasa zaimplementowana zgodnie z instrukcją z http://joel-costigliola.github.io/assertj/assertj-assertions-generator.html
public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    //Instancja Logger - do logowania wiadomości
    private Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement) {
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed(){
        logger.info("Checking if element is displayed");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
        logger.info("WebElement was displayed!");
        return this;
    }

    public AssertWebElement hasText(String expectedTextValue) {
        logger.info("Checking if WebElement has text: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();

        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement had expected text!");
        return this;
    }

    public AssertWebElement hasValue(String expectedValue) {
        logger.info("Checking if WebElement has value: " + expectedValue);
        isNotNull();

        String actualValue = actual.getAttribute("value");

        if(!actualValue.equals(expectedValue)) {
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualValue, expectedValue);
        }

        logger.info("WebElement had expected value!");
        return this;

    }

}