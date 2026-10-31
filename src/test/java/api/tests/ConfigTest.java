package api.tests;

import org.example.config.Config;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    void checkConfig() {
        System.out.println(Config.getUserServiceUrl());
        System.out.println(Config.getApplicationServiceUrl());
        System.out.println(Config.getUiBaseUrl());
        System.out.println(Config.getBrowser());
        System.out.println(Config.getTimeout());
    }
}
