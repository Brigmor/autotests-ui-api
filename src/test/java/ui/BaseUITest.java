package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.configuration.UiConfiguration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    @BeforeAll
    public static void setUp() {
        UiConfiguration.configure();
    }

    @BeforeEach
    public void openApplication() {
        open("/");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
