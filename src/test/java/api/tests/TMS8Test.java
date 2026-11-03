package api.tests;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
import api.models.request.RegisterUserRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS8Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация пользователя с неправельным подтверждением пароля")
    void test() {

        RegisterUserRequest user = UserFactory.createValidUser();
        user.setConfirmPassword("123123Pass");
        RegisterUserController.postUser(user)
                .statusCode(422)
                .body("code", Matchers.equalTo("VALIDATION_ERROR"))
                .body("message",Matchers.equalTo("Некорректные данные"))
                .body("errors.field",Matchers.hasItem(""))
                .body("errors.message",Matchers.hasItem(Matchers.containsString("Value error, Пароли не совпадают")));

    }
}
