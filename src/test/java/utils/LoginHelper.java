package utils;

import config.Config;
import io.appium.java_client.AppiumDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginHelper {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    public LoginHelper(AppiumDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.mainPage = new MainPage(driver);
    }
    public void loginAsStandardUser() {
        String user = Config.getTestUser();
        String pass = Config.getTestPassword();
        loginPage.login(user, pass);
    }

    public MainPage loginAndReturnMainPage() {
        loginAsStandardUser();
        return new MainPage(driver);
    }
}
