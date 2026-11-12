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

public class TMS10Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("auth")})
    @Feature("Авторизация пользователя")
    @Story("Авторизация с верными данными")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя с валидными данными")
    void test() {
        RegisterUserRequest user = UserFactory.createValidUser();
        RegisterUserController.postUser(user).statusCode(201);
        LoginUserRequest loginUser = LoginUserRequest.builder()
                .email(user.getEmail())
                .password(user.getPassword()).build();
        LoginUserController.postLoginUser(loginUser)
                .statusCode(200)
                .body("accessToken", Matchers.notNullValue())
                .body("accessToken", Matchers.not(Matchers.emptyString()))
                .body("tokenType", Matchers.equalTo("bearer"));
    }
}
