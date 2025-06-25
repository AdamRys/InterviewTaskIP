package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    private static void createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();

        //Capabilities settings
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appWaitActivity", "com.swaglabsmobileapp.*");
        caps.setCapability("appWaitPackage", "com.swaglabsmobileapp");

        String apkPath = System.getProperty("user.dir") + "/src/test/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
        File apkFile = new File(apkPath);
        if (!apkFile.exists()) {
            throw new RuntimeException("APK file does not exist: " + apkPath);
        }
        caps.setCapability("app", apkFile.getAbsolutePath());

        System.out.println("APK path: " + apkFile.getAbsolutePath());

        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:4723");
            System.out.println("Trying to connect to Appium at: " + appiumServerUrl);
            System.out.println("Capabilities: " + caps);

            driver = new AndroidDriver(appiumServerUrl, caps);

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}