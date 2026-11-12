package api.tests.userService;

import api.BaseApiTest;
import api.controllers.LoginUserController;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.LoginUserRequest;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TMS12Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("auth")})
    @Feature("Авторизация пользователя")
    @Story("Авторизация с неверным email")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация с неверным email")
    void test() {
        RegisterUserRequest regUser = UserFactory.createValidUser();
        RegisterUserController.postUser(regUser).statusCode(201);
        LoginUserRequest logUser = LoginUserRequest.builder()
                .email("qwe123@mail.ru")
                .password(regUser.getPassword()).build();
        LoginUserController.postLoginUser(logUser)
                .statusCode(401)
                .body("code", Matchers.equalTo("HTTP_ERROR"))
                .body("message", Matchers.equalTo("Неверный email или пароль"));
    }
}
