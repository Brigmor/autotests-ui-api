package api.tests.userService;

import api.controllers.LoginUserController;
import api.models.request.LoginUserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS13Test {
    @Test
    @Epic("API")
    @Feature("Авторизация пользователя")
    @Story("Авторизация с пустыми обязательными полями")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация с пустыми обязательными полями")
    void test() {
        LoginUserRequest user = LoginUserRequest.builder()
                .email("")
                .password("").build();
        LoginUserController.postLoginUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message", Matchers.equalTo("Некорректные данные"))
                .body("errors.field", Matchers.hasItem("email"))
                .body("errors.message", Matchers.hasItem(Matchers.
                        containsString("An email address must have an @-sign.")));
    }
}
