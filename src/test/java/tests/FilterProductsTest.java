package tests;

import base.BaseTest;
import driver.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import utils.LoginHelper;
import utils.TestHelper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("Additional TC - Unsuccessful login - Empty required fields")
public class FilterProductsTest extends BaseTest {

    private MainPage mainPage;
    private LoginHelper loginHelper;
    private String labelNameAscending = "Name (A to Z)";
    private String labelNameDescending = "Name (Z to A)";
    private String priceAscending= "Price (low to high)";
    private String priceDescending = "Price (high to low)";



    @BeforeEach
    public void setupPages(){
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        loginHelper = new LoginHelper(driver);
    }

    @Test
    @DisplayName("Filter by Name (A-Z)")
    public void filterByName(){
        loginHelper.loginAndReturnMainPage();
        mainPage.openFilterSelector();
        mainPage.selectSortByNameAscending(labelNameAscending);
        List<String> titles = mainPage.getProductTitles();
        List<String> sortedTitles = titles.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedTitles, titles, "Products are not sorted by name A-Z");

    }
    @Test
    @DisplayName("Filter by Price (low to high)")
    public void filterByPrice() {
        loginHelper.loginAndReturnMainPage();
        mainPage.openFilterSelector();
        mainPage.selectSortByPriceAscending(priceAscending);
        List<Double> prices = mainPage.getProductPrices();
        List<Double> sortedPrices = prices.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(sortedPrices, prices, "Products are not sorted by price low to high");
    }

    @Test
    @DisplayName("Filter by Name (Z-A)")
    public void filterByNameDescending() {
        loginHelper.loginAndReturnMainPage();
        mainPage.openFilterSelector();
        mainPage.selectSortByNameDescending(labelNameDescending);
        List<String> titles = mainPage.getProductTitles();
        List<String> sortedTitlesDesc = titles.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assertions.assertEquals(sortedTitlesDesc, titles, "Products are not sorted by name Z-A");
    }

    @Test
    @DisplayName("Filter by Price (high to low)")
    public void filterByPriceDescending() {
        loginHelper.loginAndReturnMainPage();
        mainPage.openFilterSelector();
        mainPage.selectSortByPriceDescending(priceDescending);
        List<Double> prices = mainPage.getProductPrices();
        List<Double> sortedPricesDesc = prices.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assertions.assertEquals(sortedPricesDesc, prices, "Products are not sorted by price high to low");
    }
}
