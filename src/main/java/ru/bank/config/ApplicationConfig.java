package ru.bank.config;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/application.properties")
public interface ApplicationConfig extends org.aeonbits.owner.Config{

    @Key("api.user-service-url")
    String userServiceUrl();

    @Key("api.application-service-url")
    String applicationServiceUrl();

    @Key("ui.base-url")
    String uiBaseUrl();

    @Key("browser")
    String browser();

    @Key("browser.headless")
    boolean headless();

    @Key("timeout")
    int timeout();

    @Key("connection.timeout")
    int connectionTimeout();

    @Key("db.url")
    String dbUrl();

    @Key("db.username")
    String dbUsername();
}