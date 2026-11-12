package ui.configuration;

import com.codeborne.selenide.Configuration;
import ru.bank.config.Config;

public class UiConfiguration {

    public static void configure() {

        Configuration.browser = Config.CONFIG_APP.browser();
        Configuration.baseUrl = Config.CONFIG_APP.uiBaseUrl();
        Configuration.headless = Config.CONFIG_APP.headless();
        Configuration.timeout = Config.CONFIG_APP.timeout();
        Configuration.browserSize = Config.CONFIG_APP.sizeBrowser();
    }
}
