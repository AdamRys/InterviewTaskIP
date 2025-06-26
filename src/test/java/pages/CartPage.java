package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;
import utils.WaitHelpers;

import java.time.Duration;

public class CartPage {
    private AppiumDriver driver;
    private ElementActions actions;
    private WaitHelpers wait;

    public CartPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        this.actions = new ElementActions(driver, 10);
        this.wait = new WaitHelpers(driver, 10);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private WebElement cartTitle;

    public boolean isCartVisible(){
        return actions.isVisible(cartTitle);
    }
    public boolean isProductInCart(String productName) {
        try {
            By productTitle = By.xpath("//android.widget.TextView[@text='" + productName + "']");
            wait.waitForVisibility(productTitle);
            return driver.findElement(productTitle).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }



}
