package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Test
    @Description("The goal of this test is to log in using not proper email and password" +
            " and check if warning message \"Authentication failed.\" is displayed")
    public void asUserTryToLogInWithIncorrectEmailAndPassword() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoEmailField("NotExisting@Email.pl")
                .typeIntoPasswordField("NotProperPassword")
                .ClickOnSignInButton()
                .assertThatWarningIsDisplayed("Authentication failed.");
    }
}
