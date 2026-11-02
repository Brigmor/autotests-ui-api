package api.tests;

import api.BaseApiTest;
import api.controllers.UserController;
import api.models.request.UserRequest;
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
        UserRequest user = UserFactory.createValidUser();
        UserController.postUser(user)
                .statusCode(201)
                .body("id", Matchers.notNullValue());
    }
}
