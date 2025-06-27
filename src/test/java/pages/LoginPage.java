package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(accessibility =  "test-Error message")
    private WebElement errorMessage;

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
    public boolean isErrorMessageVisible(){
        return errorMessage.isDisplayed();
    }
    public String getErrorMessageText() {
        return errorMessage.findElement(By.className("android.widget.TextView")).getText();
    }
}