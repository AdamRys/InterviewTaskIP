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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppLaunchTest extends BaseTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    public void initPages() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void shouldLaunchApp() {
        System.out.println("Ścieżka do APK: " + Config.getAppPath());

        String currentActivity = ((AndroidDriver) driver).currentActivity();
        System.out.println("Aktualna aktywność po starcie aplikacji: " + currentActivity);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
        Assertions.assertNotNull(el, "Aplikacja się nie uruchomiła poprawnie, brak elementów UI");
    }
    @Test
    public void testLogin(){
        loginPage.login("standard_user", "secret_sauce");
        Assertions.assertTrue(mainPage.isLoaded(), "Main page nie załadowała się po zalogowaniu");
    }
}