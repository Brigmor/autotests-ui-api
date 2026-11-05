package api.tests.userService;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.models.request.RegisterUserRequest;
import api.data.UserFactory;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS1Test extends BaseApiTest {

    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Успешная регистрация")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация нового пользователя")
    void shouldRegisterUser() {
        RegisterUserRequest user = UserFactory.createValidUser();
        RegisterUserController.postUser(user)
                .statusCode(201)
                .body("id", Matchers.notNullValue());
    }
}
