package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.ContactPage;

import static navigation.ApplicationURLs.CONTACT_US_URL;

public class PositiveMessageSentTests extends TestBase {

    @Test
    @Description("The goal of this test is to send a message on Customer service - Contact us form" +
            " and check if message \"Your message has been successfully sent to our team.\" is displayed")
    public void asUserSuccessfullySendMessageFromContactUsForm() {

        DriverUtils.navigateToPage(CONTACT_US_URL);

        ContactPage contactPage = new ContactPage();
        contactPage
                .chooseOptionFromDropdown("1")
                .typeIntoEmailAddressField("Example@Email.pl")
                .typeIntoOrderReferenceField("ExampleReference")
                .typeIntoMessageArea("Text")
                .clickOnSendMessageButton()
                .assertThatAlertIsDisplayed("Your message has been successfully sent to our team.");
    }
}
