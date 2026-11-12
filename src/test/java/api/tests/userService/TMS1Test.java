package api.tests.userService;

import api.BaseApiTest;
import api.controllers.RegisterUserController;
import api.data.UserFactory;
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

public class TMS1Test extends BaseApiTest {

    @Test
    @Tags({@Tag("api"), @Tag("reg")})
    @Feature("Регистрация пользователя")
    @Story("Успешная регистрация")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация нового пользователя")
    void test() {
        RegisterUserRequest user = UserFactory.createValidUser();
        RegisterUserController.postUser(user)
                .statusCode(201)
                .body("id", Matchers.notNullValue());
    }
}
