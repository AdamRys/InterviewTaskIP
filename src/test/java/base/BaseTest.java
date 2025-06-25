package base;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeEach
    public void setup() {
        System.out.println("Setup testu - pobieranie drivera");
        driver = DriverManager.getDriver();
        System.out.println("Driver w setup: " + driver);
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}