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

    @Key("ui.browser")
    String browser();

    @Key("ui.headless")
    boolean headless();

    @Key("ui.timeout")
    int timeout();

    @Key("ui.browser-size")
    String sizeBrowser();

    @Key("db.url")
    String dbUrl();

    @Key("db.username")
    String dbUsername();
}