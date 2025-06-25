package config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    private static String getEnv(String key, String defaultValue) {
        String value = dotenv.get(key);
        if (value == null || value.isEmpty()) {
            value = System.getenv(key);
        }
        return (value == null || value.isEmpty()) ? defaultValue : value;
    }

    public static String getPlatformName() {
        return dotenv.get("PLATFORM_NAME");
    }

    public static String getDeviceName() {
        return dotenv.get("DEVICE_NAME");
    }

    public static String getAppPath() {
        return dotenv.get("APP_PATH");
    }

    public static String getAppiumServer() {
        return dotenv.get("APPIUM_SERVER");
    }
}

