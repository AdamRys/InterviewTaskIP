package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementActions;
import utils.WaitHelpers;

import java.time.Duration;

public class LoginPage {
    private AppiumDriver driver;
    private ElementActions actions;
    private WaitHelpers wait;

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement usernameField;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        this.actions = new ElementActions(driver, 10);
        this.wait = new WaitHelpers(driver, 10);
    }

    public void login(String username, String password) {
        wait.waitForVisibility(usernameField);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        actions.click(loginButton);

    }
}