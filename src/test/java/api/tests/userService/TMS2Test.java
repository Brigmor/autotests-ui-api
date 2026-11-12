package api.tests.userService;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
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

public class TMS2Test extends BaseApiTest {
    @Test
    @Tags({@Tag("api"), @Tag("reg")})
    @Feature("Регистрация пользователя")
    @Story("Регистрация с незаполненными обязательными полями")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Регистрация пользователя c пустыми полями")
    void test() {

        RegisterUserController.postUser(getRegisterRequest())
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message", Matchers.equalTo("Некорректные данные"))
                .body("errors", Matchers.not(Matchers.empty()))
                .body("errors.field", Matchers.hasItems(
                        "firstName",
                        "lastName",
                        "email",
                        "phone",
                        "password"
                ));
    }

    private RegisterUserRequest getRegisterRequest() {
        return   RegisterUserRequest.builder()
                .firstName("")
                .lastName("")
                .phone("")
                .email("")
                .password("")
                .confirmPassword("")
                .consent(false)
                .build();
    }
}
