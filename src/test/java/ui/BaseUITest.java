package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.configuration.UiConfiguration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    @BeforeAll
    static void setUp() {
        UiConfiguration.configure();
    }

    @BeforeEach
     void openApplication () {
        open("/");
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
