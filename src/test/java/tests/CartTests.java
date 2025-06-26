package tests;

import base.BaseTest;
import data.ProductData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.MainPage;
import utils.ElementActions;
import utils.LoginHelper;
import utils.WaitHelpers;

import java.util.List;

public class CartTests extends BaseTest {

    private MainPage mainPage;
    private CartPage cartPage;
    private WaitHelpers waitHelpers;
    private ElementActions actions;
    private LoginHelper loginHelper;

    @BeforeEach
    public void setupPages() {
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        waitHelpers = new WaitHelpers(driver, 10);
        actions = new ElementActions(driver, 10);
        loginHelper = new LoginHelper(driver);
    }

    @Test
    @DisplayName("Add the product to the shopping cart and confirm that the added product is displayed.")
    public void AddedProductIsDisplayed(){
        loginHelper.loginAndReturnMainPage();
        mainPage.clickAddToCartByProductName(ProductData.BACKPACK_NAME);
        mainPage.openCart();
        Assertions.assertTrue(cartPage.isCartVisible(), "Cart was not opened – element 'YOUR CART' is not visible");
        Assertions.assertTrue(cartPage.isProductInCart(ProductData.BACKPACK_NAME),
                "Product '" + ProductData.BACKPACK_NAME + "' was not found in your cart");

        //lines to verification if tests is working correctly
//        Assertions.assertTrue(cartPage.isProductInCart(ProductData.BIKE_LIGHT_NAME),
//                "Product '" + ProductData.BIKE_LIGHT_NAME + "' was not found in your cart");
    }


}
