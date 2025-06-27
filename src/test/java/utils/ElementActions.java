package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private AppiumDriver driver;
    private WaitHelpers wait;

    public ElementActions(AppiumDriver driver, long timeoutSeconds) {
        this.driver = driver;
        this.wait = new WaitHelpers(driver, timeoutSeconds);
    }
    //Wait and click
    public void click(WebElement element) {
        System.out.println("Clicking on: " + element);
        wait.waitForClickable(element).click();
    }
    //Input text to field
    public void sendKeys(WebElement element, String text) {
        wait.waitForVisibility(element);
        System.out.println("Sending keys to: " + element);
        element.clear();
        element.sendKeys(text);
    }
    //Getting text of element
    public String getText(WebElement element) {
        wait.waitForVisibility(element);
        System.out.println("Getting element: " + element);
        return element.getText();
    }
    //Check if element is visible
    public boolean isVisible(WebElement element) {
        try {
            wait.waitForVisibility(element);
            System.out.println("Checking if element: " + element + "is visible");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void scrollToElementByAccessibilityId(String accessibilityId) {
        String uiSelector = "new UiScrollable(new UiSelector().scrollable(true))"
                + ".scrollIntoView(new UiSelector().description(\"" + accessibilityId + "\"))";

        driver.findElement(AppiumBy.androidUIAutomator(uiSelector));
    }
}
