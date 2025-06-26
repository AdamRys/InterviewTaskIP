package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementActions;
import utils.WaitHelpers;

import java.time.Duration;

public class MainPage {
    private AppiumDriver driver;
    private WaitHelpers wait;
    private ElementActions actions;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    public MainPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        this.wait = new WaitHelpers(driver, 10);
        this.actions = new ElementActions(driver, 10);
    }
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(addToCartButton));
            return addToCartButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickAddToCartByProductName(String productName) {
        By addToCartBtn = By.xpath(
                "//android.widget.TextView[@content-desc='test-Item title' and @text='" + productName + "']" +
                        "/ancestor::android.view.ViewGroup[@content-desc='test-Item']" +
                        "//android.view.ViewGroup[@content-desc='test-ADD TO CART']"
        );
        wait.waitForClickable(addToCartBtn).click();
    }
    public void openCart(){
        wait.waitForClickable(cartButton);
        actions.click(cartButton);
    }
}
