package ui.tests.userService;

import api.data.UserFactory;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ui.BaseUITest;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;
import ui.pages.RegisterPage;

public class TMS22Test extends BaseUITest {


    @Test
    @Tags({@Tag("ui"), @Tag("auth")})
    void test() {
        var user = UserFactory.createValidUser();
        regUser(user);
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickButtonLogin();
        new DashboardPage()
                .checkDashboardTitle();
    }

    @Step("регистрация нового пользователя")
    private void regUser(RegisterUserRequest user) {
        new RegisterPage()
                .openPage()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPhone(user.getPhone())
                .setPassword(user.getPassword())
                .setConfirmPassword(user.getConfirmPassword())
                .acceptTerms()
                .clickRegisterButton();
    }
}

