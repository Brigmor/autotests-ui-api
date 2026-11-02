package api.tests;

import api.BaseApiTest;
import api.controllers.UserController;
import api.data.UserFactory;
import api.models.request.UserRequest;
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

        UserRequest user = UserFactory.createValidUser();
        user.setPhone("invalid-phone");

        UserController.postUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message",Matchers.equalTo("Некорректные данные"))
                .body("errors.field", Matchers.hasItem("phone"))
                .body("errors.message",Matchers.hasItems(Matchers.containsString("String should match pattern")));
    }
}
