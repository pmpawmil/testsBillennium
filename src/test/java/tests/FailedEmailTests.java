package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedEmailTests extends TestBase {

    @Test
    @Description("The goal of this test is to log in using not proper email " +
            " and check if warning message \"Invalid email address\" is displayed")
    public void asUserTryToLogInWithIncorrectEmail() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoEmailField("NotExistingEmail")
                .typeIntoPasswordField("NotProperPassword")
                .ClickOnSignInButton()
                .assertThatWarningIsDisplayed("Invalid email address.");
    }
}
