package org.example.api.clients;

import io.restassured.response.Response;
import org.example.api.BaseApi;
import org.example.api.endpoints.UserEndpoints;
import org.example.api.specification.Specification;
import org.example.models.UserRequest;

public class UserApi extends BaseApi {

    public UserApi () {
        super(Specification.BaseSpec());
    }

    public Response registerUser(UserRequest user) {
        return request()
                .body(user)
                .when()
                .post(UserEndpoints.REGISTER.getPath());
    }

}
