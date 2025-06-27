package config;

public class PlatformConfig {


    public static String getPlatformName() {
        return System.getenv().getOrDefault("PLATFORM_NAME", "Android");
    }

    public static String getDeviceName() {
        return System.getenv().getOrDefault("DEVICE_NAME", "emulator-5554");
    }

    public static String getAppPath() {
        return System.getenv().getOrDefault("APP_PATH", "src/test/resources/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
    }

    public static String getAppiumServer() {
        return System.getenv().getOrDefault("APPIUM_SERVER", "http://127.0.0.1:4723");
    }

    public static String getPlatformVersion() {
        return System.getenv().getOrDefault("IOS_PLATFORM_VERSION", "14.5");
    }

    public static String getBundleId() {
        return System.getenv().getOrDefault("IOS_BUNDLE_ID", "com.example.iosapp");
    }

}
