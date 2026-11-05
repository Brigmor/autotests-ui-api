package api.tests.userService;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS7Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Регистрация с паролем меньше 8 символов")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация пользователя с паролем меньше 8 символов")
    void test() {

        RegisterUserRequest user = UserFactory.createValidUser();
        user.setPassword("1234");

        RegisterUserController.postUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message",Matchers.equalTo("Некорректные данные"))
                .body("errors.field",Matchers.hasItem("password"))
                .body("errors.message",Matchers.hasItems(Matchers.containsString("String should have at least 8 characters")));
    }
}
