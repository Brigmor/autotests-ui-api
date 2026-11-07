package api.controllers;

import api.endpoints.UserEndpoints;
import api.models.request.RegisterUserRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class RegisterUserController {

    @Step("Создать пользователя с логином - [{body.email}]")
    public static ValidatableResponse postUser(RegisterUserRequest body) {
        return given()
                .spec(Specification.baseUserService())
                .body(body)
                .post(UserEndpoints.REGISTER.getPath())
                .then().log().all();
    }
}
