package base;

import config.Config;
import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {
    protected AppiumDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;

    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}