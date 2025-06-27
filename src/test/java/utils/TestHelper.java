package utils;

import data.ProductData;
import io.appium.java_client.AppiumDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.MainPage;

public class TestHelper {
    private AppiumDriver driver;
    private MainPage mainPage;
    private CartPage cartPage;
    private LoginHelper loginHelper;
    public CheckoutPage checkoutPage;


    public TestHelper(AppiumDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loginHelper = new LoginHelper(driver);
    }
    public void prepareCartWithProductAndOpenCart(ProductData product) {
        loginHelper.loginAndReturnMainPage();
        mainPage.clickAddToCartByProductName(ProductData.BACKPACK);
        mainPage.openCart();
    }

    public void fillCheckoutForm(String first, String last, String zip) {
        checkoutPage.fillForm(first, last, zip);
        checkoutPage.clickContinue();
    }

    public void goThroughCheckoutWithData(String first, String last, String zip) {
        cartPage.goToCheckout();
        fillCheckoutForm(first, last, zip);
        checkoutPage.clickContinue();
    }
}
