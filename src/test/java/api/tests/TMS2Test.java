package api.tests;

import api.BaseApiTest;
import api.controllers.UserController;
import api.data.UserFactory;
import api.models.request.UserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS2Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Регистрация с незаполненными обязательными полями")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Регистрация пользователя c пустыми полями")
     void test() {

        UserRequest user = UserRequest.builder()
                .firstName("")
                .lastName("")
                .phone("")
                .email("")
                .password("")
                .confirmPassword("")
                .consent(false)
                .build();

        UserController.postUser(user)
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
}
