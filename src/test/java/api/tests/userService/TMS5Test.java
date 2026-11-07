package api.tests.userService;

import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS5Test {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Повторная регистрация с уже существующим номером телефона")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Повторная регистрация пользователя с уже зарегистрированным номером телефона")
    void test() {
        RegisterUserRequest secondUser = UserFactory.createValidUser();
        RegisterUserController.postUser(secondUser).statusCode(201);
        RegisterUserRequest user = UserFactory.createValidUser();
        user.setPhone(secondUser.getPhone());
        RegisterUserController.postUser(user)
                .statusCode(409)
                .body("code", Matchers.equalTo("HTTP_ERROR"))
                .body("message", Matchers.equalTo("Email or phone already exists"))
                .body("errors", Matchers.empty());
    }
}
