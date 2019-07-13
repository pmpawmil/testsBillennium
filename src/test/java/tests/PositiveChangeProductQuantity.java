package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.PRINTED_DRESS_URL;

public class PositiveChangeProductQuantity extends TestBase{

    @Test
    @Description("The goal of this test is to enter Printed Dress Product Page, increment a value " +
            "in quantity wanted field and check if the quantity changed from previous value.")
    public void asUserSuccessfullyChangeQuantityOfTheProduct() {

        DriverUtils.navigateToPage(PRINTED_DRESS_URL);

        PrintedDressProductPage printedDressProductPage = new PrintedDressProductPage();
        printedDressProductPage.assertThatValueChangedAfterUpButtonClicked();
    }
}
