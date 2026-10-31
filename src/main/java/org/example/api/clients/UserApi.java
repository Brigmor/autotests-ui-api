package org.example.api.clients;

import io.restassured.response.Response;
import org.example.api.BaseApi;
import org.example.api.endpoints.UserEndpoints;
import org.example.api.specification.Specification;
import org.example.models.ApiResponse;
import org.example.models.request.UserRequest;
import org.example.models.response.UserResponse;

public class UserApi extends BaseApi {

    public UserApi () {
        super(Specification.baseSpec());
    }

    public ApiResponse<UserResponse> registerUser(UserRequest user) {

        Response response = request()
                .body(user)
                .when()
                .post(UserEndpoints.REGISTER.getPath());

        return new ApiResponse<>(
                response.statusCode(),
                response.as(UserResponse.class));
    }

}
