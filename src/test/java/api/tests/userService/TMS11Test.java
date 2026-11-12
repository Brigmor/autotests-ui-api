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

public class TMS11Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("auth")})
    @Feature("Авторизация пользователя")
    @Story("Авторизация с неверным паролем")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация с неверным паролем")
    void test() {
        RegisterUserRequest regUser = UserFactory.createValidUser();
        RegisterUserController.postUser(regUser).statusCode(201);
        LoginUserRequest loginUser = LoginUserRequest.builder()
                .password("123qwe123").build();
        LoginUserController.postLoginUser(loginUser)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message", Matchers.equalTo("Некорректные данные"))
                .body("errors.field", Matchers.hasItem("email"))
                .body("errors.message", Matchers.hasItem(Matchers.containsString("Input should be a valid string")));
    }
}
