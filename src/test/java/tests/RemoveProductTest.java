package tests;

import base.BaseTest;
import data.ProductData;
import driver.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import utils.LoginHelper;
import utils.TestHelper;

public class RemoveProductTest extends BaseTest {
    private MainPage mainPage;
    private CartPage cartPage;
    private LoginHelper loginHelper;
    private TestHelper testHelper;

    @BeforeEach
    public void setupPages() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        loginHelper = new LoginHelper(driver);
        testHelper = new TestHelper(driver);
    }

    @Test
    @DisplayName("Remove product from cart and verify update")
    public void removeProductFromCart() {
        loginHelper.loginAndReturnMainPage();
        mainPage.clickAddToCartByProductName(ProductData.BACKPACK);
        mainPage.openCart();
        Assertions.assertTrue(cartPage.isProductInCartVisible(ProductData.BACKPACK.getName()),
                "Product '" + ProductData.BACKPACK.getName() + "' was not found in your cart");
        cartPage.clickRemoveButton();
        Assertions.assertFalse(cartPage.isProductInCartVisible(ProductData.BACKPACK.getName()),
                "Product '" + ProductData.BACKPACK.getName() + "' is still present in the cart after removal");
    }
}
