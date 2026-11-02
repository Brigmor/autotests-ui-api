package api.tests;

import api.BaseApiTest;
import api.controllers.UserController;
import api.data.UserFactory;
import api.models.request.UserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS3Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Регистрация пользователя с неправильным форматом email")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация пользователя с неправильным форматом email")
     void test() {

        UserRequest user = UserFactory.createValidUser();
        user.setEmail("invalid-email");
        UserController.postUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message", Matchers.equalTo("Некорректные данные"))
                .body("errors", Matchers.not(Matchers.empty()))
                .body("errors.field", Matchers.hasItems("email"))
                .body("errors.message", Matchers.equalTo("value is not a valid email address: An email address must have an @-sign."));

    }
}
