package base;

import driver.DriverFactory;
import driver.DriverManager;
import config.PlatformConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {
    protected AppiumDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;

    @BeforeEach
    public void setup() {
        AppiumDriver driver = DriverFactory.createDriver(PlatformConfig.getPlatformName());
        DriverManager.setDriver(driver);
//
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}