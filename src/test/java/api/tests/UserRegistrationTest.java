package api.tests;

import api.BaseTestApi;
import api.testdata.UserFactory;
import io.qameta.allure.*;
import org.example.models.ApiResponse;
import org.example.models.request.UserRequest;
import org.example.models.response.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest extends BaseTestApi {
    @Epic("API")
    @Feature("Регистрация пользователя")
    @Story("Успешная регистрация")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация нового пользователя")
    @Test
    void shouldRegisterUser() {
        UserRequest user = UserFactory.createValidUser();
        ApiResponse<UserResponse> response = userApi.registerUser(user);

        assertEquals(201, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertFalse(response.getBody().getId().isBlank());





    }


}
