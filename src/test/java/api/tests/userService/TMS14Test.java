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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class TMS14Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("auth")})
    @Feature("Авторизация пользователя")
    @Story("Авторизация с некорректным форматом email")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация с некорректным форматом email")
    void test() {
        RegisterUserRequest regUser = UserFactory.createValidUser();
        RegisterUserController.postUser(regUser);
        LoginUserRequest loginUser = LoginUserRequest.builder()
                .email("invalid-email")
                .password(regUser.getPassword())
                .build();

        LoginUserController.postLoginUser(loginUser)
                .statusCode(422)
                .body("code", equalTo("VALIDATION_ERROR"))
                .body("message", equalTo("Некорректные данные"))
                .body("errors.field", hasItem("email"))
                .body("errors.message",
                        hasItem(containsString("An email address must have an @-sign")));
    }


}
