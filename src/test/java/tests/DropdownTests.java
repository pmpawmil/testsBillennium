package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.ContactPage;

import static navigation.ApplicationURLs.CONTACT_US_URL;

public class DropdownTests extends TestBase {

        @Test
        @Description("The goal of this test is to test choosing different options from dropdown" +
                " and check if message is appropriate.")
        public void asUserChooseFromDropdown() {

                DriverUtils.navigateToPage(CONTACT_US_URL);

                ContactPage contactPage = new ContactPage();
                contactPage.assertThatDropdownOptionTextIsProper("0", "-- Choose --");
                contactPage.assertThatDropdownOptionTextIsProper("2", "Customer service");
                contactPage.assertThatDropdownOptionTextIsProper("1", "Webmaster");
        }
}
