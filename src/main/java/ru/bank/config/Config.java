package ru.bank.config;

import org.aeonbits.owner.ConfigFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//Берем настройки из application
public class Config {

private static final ApplicationConfig CONFIG =
        ConfigFactory.create(ApplicationConfig.class);

    private Config() {
    }

    public static String getUserServiceUrl() {
        return CONFIG.userServiceUrl();
    }

    public static String getApplicationServiceUrl() {
        return CONFIG.applicationServiceUrl();
    }

    public static String getUiBaseUrl() {
        return CONFIG.uiBaseUrl();
    }

    public static String getBrowser() {
        return CONFIG.browser();
    }

    public static boolean isHeadless() {
        return CONFIG.headless();
    }

    public static int getTimeout() {
        return CONFIG.timeout();
    }

    public static int getConnectionTimeout() {
        return CONFIG.connectionTimeout();
    }
}
