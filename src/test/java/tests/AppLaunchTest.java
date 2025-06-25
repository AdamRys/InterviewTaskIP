package tests;

import base.BaseTest;
import config.Config;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LoginHelper;
import utils.WaitHelpers;


public class AppLaunchTest extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;
    private WaitHelpers wait;
    private LoginHelper loginHelper;

    @BeforeEach
    public void initPages() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        wait = new WaitHelpers(driver, 10);
        loginHelper = new LoginHelper(driver);
    }

    @Test
    public void shouldLaunchApp() {
        System.out.println("Path to app: " + Config.getAppPath());

        String currentActivity = ((AndroidDriver) driver).currentActivity();
        System.out.println("Actual activity after start of app: " + currentActivity);

        WebElement el = wait.waitForVisibility(By.xpath("//*"));
        Assertions.assertNotNull(el, "App is not loaded correctly, there are UI elements missing");
    }
    @Test
    public void testLogin(){
        loginHelper.loginAsStandardUser();
        Assertions.assertTrue(mainPage.isLoaded(), "Main page is not loaded after log in");
    }
}