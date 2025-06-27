package tests;

import base.BaseTest;
import data.ProductData;
import data.UserData;
import driver.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.MainPage;
import utils.TestHelper;
import utils.LoginHelper;

@DisplayName("Required Test Case")
public class MainTestCase extends BaseTest {

    private MainPage mainPage;
    private CartPage cartPage;
    private LoginHelper loginHelper;
    private TestHelper testHelper;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    @BeforeEach
    public void setupPages() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        loginHelper = new LoginHelper(driver);
        testHelper = new TestHelper(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }
    //I split one big test case for few tests to assert few "Stages" described in test case (made final case below)
    @Test
    @DisplayName("TC(pt.1) - 1. Add the product to the shopping cart and confirm that the added product is displayed.")
    public void AddedProductIsDisplayed(){
        loginHelper.loginAndReturnMainPage();
        mainPage.clickAddToCartByProductName(ProductData.BACKPACK);
        mainPage.openCart();
        Assertions.assertTrue(cartPage.isCartVisible(), "Cart was not opened – element 'YOUR CART' is not visible");
        Assertions.assertTrue(cartPage.isProductInCartVisible(ProductData.BACKPACK.getName()),
                "Product '" + ProductData.BACKPACK.getName() + "' was not found in your cart");

        //lines to verification if tests is working correctly
//        Assertions.assertTrue(cartPage.isProductInCart(ProductData.BIKE_LIGHT_NAME),
//                "Product '" + ProductData.BIKE_LIGHT.getName() + "' was not found in your cart");
    }
    @Test
    @DisplayName("TC(pt.2-4) - 2. Open the shopping cart and continue. Fill in all required information fields., 3. Proceed to order overview 4. Ensure the Checkout screen displays correct order details")
    void shouldOpenCartAndFillCheckoutInformation() {
        testHelper.prepareCartWithProductAndOpenCart(ProductData.BACKPACK);
        cartPage.goToCheckout();
        checkoutPage.fillForm(UserData.BASICUSER.getName(), UserData.BASICUSER.getLast(), UserData.BASICUSER.getZip());
        checkoutPage.clickContinue();
        Assertions.assertTrue(checkoutOverviewPage.isOverviewVisible(), "Checkout Overview Page is not visible");
        Assertions.assertTrue(
                checkoutOverviewPage.isProductTitleCorrect(ProductData.BACKPACK.getName()),
                "Incorrect name of product in overview");
        Assertions.assertTrue(
                checkoutOverviewPage.isProductDescriptionCorrect(ProductData.BACKPACK.getDescription()),
                "Incorrect description of product in overview");
        Assertions.assertTrue(
                checkoutOverviewPage.isProductPriceCorrect("$" + String.format("%.2f", ProductData.BACKPACK.getPrice())),
                "Incorrect price of product in overview");
    }
    //Complete Required TestCase
    @Test
    @DisplayName("Final Test Case (pt.1-5)")
    void completePurchaseProcess(){
        testHelper.prepareCartWithProductAndOpenCart(ProductData.BACKPACK);
        testHelper.goThroughCheckoutWithData(UserData.BASICUSER.getName(), UserData.BASICUSER.getLast(), UserData.BASICUSER.getZip());
        checkoutOverviewPage.finishCheckout();
        Assertions.assertTrue(checkoutOverviewPage.isPonyCompletedVisible(), "Graphic with pony that implies that order is completed is not visible :(");
    }


}
