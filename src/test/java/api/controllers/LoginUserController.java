package api.controllers;

import api.endpoints.UserEndpoints;
import api.models.request.LoginUserRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginUserController {
    @Step("Авторизация пользователя")
    public static ValidatableResponse postLoginUser (LoginUserRequest body) {

        return given()
                .spec(Specification.baseSpec())
                .body(body)
                .post(UserEndpoints.LOGIN.getPath())
                .then().log().all();
    }
}
