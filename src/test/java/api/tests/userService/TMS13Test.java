package api.tests.userService;

import api.controllers.LoginUserController;
import api.models.request.LoginUserRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TMS13Test {
    @Test
    @Tags({@Tag("api"), @Tag("auth")})
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
