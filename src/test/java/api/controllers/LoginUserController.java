package api.controllers;

import api.endpoints.UserEndpoints;
import api.models.request.LoginUserRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginUserController {

    @Step("Авторизация пользователя c логином - [{body.email}]")
    public static ValidatableResponse postLoginUser(LoginUserRequest body) {
        return given()
                .spec(Specification.baseUserService())
                .body(body)
                .post(UserEndpoints.LOGIN.getPath())
                .then().log().all();
    }
}
