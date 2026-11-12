package ui.tests.userService;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.BaseUITest;
import ui.pages.RegisterPage;

public class TMS21Test extends BaseUITest {
    @Test
    @Tags({@Tag("ui"),@Tag("reg")})
    @Feature("Регистрация пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Зарегистрировать пользователя с валидными данными")
    void test() {

        new RegisterPage()
                .openPage()
                .setFirstName("Алекс")
                .setLastName("Алекс")
                .setEmail("testt@mai.ru")
                .setPhone("+79212435130")
                .setPassword("8921adad")
                .setConfirmPassword("8921adad")
                .acceptTerms()
                .clickRegisterButton();
    }
}
