package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.intellij.lang.annotations.JdkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementActions;
import java.util.List;

import java.time.Duration;

public class CheckoutOverviewPage {
    private AppiumDriver driver;
    private ElementActions actions;

    public CheckoutOverviewPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        this.actions = new ElementActions(driver, 10);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private WebElement checkoutOverviewTitle;

    @AndroidFindBy(accessibility = "test-FINISH")
    private WebElement finishButton;

    @AndroidFindBy(accessibility = "test-Description")
    private List<WebElement> productDescriptionContainers;

    @AndroidFindBy(accessibility = "test-Price")
    private List<WebElement> productPriceContainers;

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    private WebElement completedPony;

    private String aIdFinishButton = "test-FINISH";

    public boolean isOverviewVisible(){
        return actions.isVisible(checkoutOverviewTitle);
    }

    public void finishCheckout(){
        actions.scrollToElementByAccessibilityId(aIdFinishButton);
        actions.click(finishButton);
    }

    public boolean isProductTitleCorrect(String expectedTitle) {
        return productDescriptionContainers.stream()
                .map(container -> container.findElements(By.className("android.widget.TextView")))
                .filter(textViews -> !textViews.isEmpty())
                .map(textViews -> textViews.get(0).getText().trim())
                .peek(title -> System.out.println("Found title: " + title))// This is first element of container, so title
                .anyMatch(title -> title.equals(expectedTitle));
    }

    public boolean isProductDescriptionCorrect(String expectedDescription) {
        return productDescriptionContainers.stream()
                .map(container -> container.findElements(By.className("android.widget.TextView")))
                .filter(textViews -> textViews.size() > 1)
                .map(textViews -> textViews.get(1).getText().trim())
                .peek(title -> System.out.println("Found descriptions: " + title))// And second element of container - description
                .anyMatch(description -> description.equals(expectedDescription));
    }

    public boolean isProductPriceCorrect(String expectedPrice) {
        return productPriceContainers.stream()
                .map(container -> container.findElement(By.className("android.widget.TextView")).getText().trim())
                .anyMatch(price -> price.equals(expectedPrice));
    }

    public boolean isPonyCompletedVisible(){
        return actions.isVisible(completedPony);
    }

}
