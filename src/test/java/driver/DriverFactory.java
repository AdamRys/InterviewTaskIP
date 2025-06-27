package driver;

import config.PlatformConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static AppiumDriver createDriver(String platformName) {
        DesiredCapabilities caps = new DesiredCapabilities();
        AppiumDriver driver;

        if ("Android".equalsIgnoreCase(platformName)) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", PlatformConfig.getDeviceName());
            caps.setCapability("appWaitActivity", "com.swaglabsmobileapp.*");
            caps.setCapability("appWaitPackage", "com.swaglabsmobileapp");

            String apkPath = PlatformConfig.getAppPath();
            File apkFile = new File(apkPath);
            if (!apkFile.exists()) {
                throw new RuntimeException("APK file does not exist: " + apkPath);
            }
            caps.setCapability("app", apkFile.getAbsolutePath());

            try {
                driver = new AndroidDriver(new URL(PlatformConfig.getAppiumServer()), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL", e);
            }

        } else if ("iOS".equalsIgnoreCase(platformName)) {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("deviceName", PlatformConfig.getDeviceName());
            caps.setCapability("platformVersion", PlatformConfig.getPlatformVersion());
            caps.setCapability("bundleId", PlatformConfig.getBundleId());

            try {
                driver = new IOSDriver(new URL(PlatformConfig.getAppiumServer()), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL", e);
            }
        } else {
            throw new RuntimeException("Unsupported platform: " + platformName);
        }

        return driver;
    }
}
