package tests;

import base.BaseTest;
import config.Config;
import driver.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;


@DisplayName("Additional TC - Unsuccessful login - Empty required fields")
public class LoginErrorMessageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void initPages() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Empty login")
    public void emptyLoginTC(){
        String user = "";
        String pass = Config.getTestPassword();
        loginPage.login(user, pass);
        Assertions.assertTrue(loginPage.isErrorMessageVisible(), "Error message is not visible");
        Assertions.assertEquals("Username is required", loginPage.getErrorMessageText());
    }
    @Test
    @DisplayName("Empty password")
    public void emptyPasswordTC(){
        String user = Config.getTestUser();
        String pass = "";
        loginPage.login(user, pass);
        Assertions.assertTrue(loginPage.isErrorMessageVisible(), "Error message is not visible");
        Assertions.assertEquals("Password is required", loginPage.getErrorMessageText());
    }
}
