package api.tests;

import api.BaseTestApi;
import api.testdata.UserFactory;
import io.restassured.response.Response;
import org.example.models.ApiResponse;
import org.example.models.request.UserRequest;
import org.example.models.response.UserResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tms1 extends BaseTestApi {

    @Test
    void Test() {
        UserRequest user = UserFactory.createValidUser();
        ApiResponse<UserResponse> response = userApi.registerUser(user);

        assertEquals(201, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertFalse(response.getBody().getId().isBlank());





    }


}
