package api.tests;

import api.BaseApiTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS14Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Авторизация пользователя")
    @Story("Авторизация с некорректным форматом email")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация с некорректным форматом email")
    void test() {

    }
}
