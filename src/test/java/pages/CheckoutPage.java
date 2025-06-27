package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;
import utils.WaitHelpers;

import java.time.Duration;

public class CheckoutPage {
    private AppiumDriver driver;
    private ElementActions actions;
    private WaitHelpers wait;

    public CheckoutPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        this.actions = new ElementActions(driver, 10);
        this.wait = new WaitHelpers(driver, 10);
    }

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement zipCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement countinueButton;

    public void fillForm(String first, String last, String zip){
        wait.waitForClickable(firstNameField);
        actions.sendKeys(firstNameField, first);
        actions.sendKeys(lastNameField, last);
        actions.sendKeys(zipCodeField, zip);
    }
    public void clickContinue(){
        actions.click(countinueButton);
    }
}
