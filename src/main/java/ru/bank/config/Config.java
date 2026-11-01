package ru.bank.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//Берем настройки из application
public class Config {
//TODO: ПЕРЕДЕЛАТЬ НА БИБЛИОТЕКУ OWNER
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = Config.class
                .getClassLoader()
                .getResourceAsStream("config/application.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "application.properties not found"
                );
            }

            PROPERTIES.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load application.properties", e
            );
        }
    }

    private Config() {
    }

    private static String get(String key) {
        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Configuration property is missing: " + key
            );
        }

        return value.trim();
    }

    public static String getUserServiceUrl() {
        return get("api.user-service-url");
    }

    public static String getApplicationServiceUrl() {
        return get("api.application-service-url");
    }

    public static String getUiBaseUrl() {
        return get("ui.base-url");
    }

    public static String getBrowser() {
        return get("browser");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("browser.headless"));
    }

    public static int getTimeout() {
        return Integer.parseInt(get("timeout"));
    }

    public static int getConnectionTimeout() {
        return Integer.parseInt(get("connection.timeout"));
    }
}
