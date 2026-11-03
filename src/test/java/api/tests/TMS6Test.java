package api.tests;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS6Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Регистрация с некорректным форматом номера телефона")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Зарегистрировать пользователя с некорректным форматом номера телефона")
    void test(){

        RegisterUserRequest user = UserFactory.createValidUser();
        user.setPhone("invalid-phone");

        RegisterUserController.postUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message",Matchers.equalTo("Некорректные данные"))
                .body("errors.field", Matchers.hasItem("phone"))
                .body("errors.message",Matchers.hasItems(Matchers.containsString("String should match pattern")));
    }
}
