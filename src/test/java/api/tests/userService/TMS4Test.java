package api.tests.userService;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
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

public class TMS4Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("reg")})
    @Feature("Регистрация пользователя")
    @Story("Повторная регистрация с уже существующим email")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Повторная регистрация пользователя с уже зарегистрированным email")
    void test() {
        RegisterUserRequest oldUser = UserFactory.createValidUser();
        RegisterUserController.postUser(oldUser).statusCode(201);
        RegisterUserRequest user = UserFactory.createValidUser();
        user.setEmail(oldUser.getEmail());
        RegisterUserController.postUser(user)
                .statusCode(409)
                .body("code", Matchers.equalTo("HTTP_ERROR"))
                .body("message", Matchers.equalTo("Email or phone already exists"))
                .body("errors", Matchers.empty());
    }
}
