package pages;

import data.ProductData;
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
import java.util.List;
import java.util.stream.Collectors;

public class MainPage {
    private AppiumDriver driver;
    private WaitHelpers wait;
    private ElementActions actions;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "test-Cart")
    private WebElement cartButton;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private WebElement filterButton;

    @AndroidFindBy(accessibility = "Selector container")
    private WebElement selectorContainer;

    @AndroidFindBy(accessibility = "test-Item title")
    private List<WebElement> productTitles;

    @AndroidFindBy(accessibility = "test-Price")
    private List<WebElement> productPrices;


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
    public void clickAddToCartByProductName(ProductData product) {
        By addToCartBtn = By.xpath(
                "//android.widget.TextView[@content-desc='test-Item title' and @text='" + product.getName() + "']" +
                        "/ancestor::android.view.ViewGroup[@content-desc='test-Item']" +
                        "//android.view.ViewGroup[@content-desc='test-ADD TO CART']"
        );
        wait.waitForClickable(addToCartBtn).click();
    }
    public void openCart(){
        wait.waitForClickable(cartButton);
        actions.click(cartButton);
    }
    public void openFilterSelector() {
        filterButton.click();
    }

    public void selectSortByNameAscending(String label) {
        List<WebElement> options = selectorContainer.findElements(By.className("android.widget.TextView"));
        for (WebElement option : options) {
            if (option.getText().equals(label)) {
                option.click();
                break;
            }
        }
    }
    public List<String> getProductTitles() {
        return productTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    public void selectSortByPriceAscending(String label) {
        List<WebElement> options = selectorContainer.findElements(By.className("android.widget.TextView"));
        for (WebElement option : options) {
            if (option.getText().equals(label)) {
                option.click();
                break;
            }
        }
    }
    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(w -> Double.parseDouble(w.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }
    public void selectSortByNameDescending(String label) {
        List<WebElement> options = selectorContainer.findElements(By.className("android.widget.TextView"));
        for (WebElement option : options) {
            if (option.getText().equals(label)) {
                option.click();
                break;
            }
        }
    }

    public void selectSortByPriceDescending(String label) {
        List<WebElement> options = selectorContainer.findElements(By.className("android.widget.TextView"));
        for (WebElement option : options) {
            if (option.getText().equals(label)) {
                option.click();
                break;
            }
        }
    }
}
