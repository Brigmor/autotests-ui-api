package ui.tests.userService;

import api.data.UserFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.BaseUITest;
import ui.pages.LoginPage;
import ui.pages.RegisterPage;

public class TMS21Test extends BaseUITest {

    @Test
    @Tags({@Tag("ui"), @Tag("reg")})
    @Feature("Регистрация пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Зарегистрировать пользователя с валидными данными")
    public void test() {
        new RegisterPage()
                .openPage()
                .setFirstName(UserFactory.createValidUser().getFirstName())
                .setLastName(UserFactory.createValidUser().getLastName())
                .setEmail(UserFactory.createValidUser().getEmail())
                .setPhone(UserFactory.createValidUser().getPhone())
                .setPassword(UserFactory.createValidUser().getPassword())
                .setConfirmPassword(UserFactory.createValidUser().getConfirmPassword())
                .acceptTerms()
                .clickRegisterButton();
        new LoginPage()
                .checkSuccessfulRegistrationMessage();
    }
}
