package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.TopMenuPage;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class ShoppingCartTests extends TestBase {

    @Test
    @Description("The goal of this test is to enter empty basket from main menu" +
            " and check if message \"Your shopping cart is empty.\" is displayed")
    public void asUserEntersEmptyShoppingCart() {

        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnShoppingCartLink()
                .assertThatAlertIsDisplayed("Your shopping cart is empty.");
    }

    @Test
    @Description("The goal of this test is to add an item to shopping cart, proceed to checkout " +
            " and check if message \"Product successfully added to your shopping cart\" is displayed")
    public void asUserSuccessfullyAddedProductToShoppingCart() {

        DriverUtils.navigateToPage(APPLICATION_URL);

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.addItemToShoppingCart()
                .assertThatSuccessfullyAddedProductMessageIsDisplayed("Product successfully added to your shopping cart");
    }
}
