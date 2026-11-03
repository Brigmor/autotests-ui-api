package api.controllers;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import api.endpoints.UserEndpoints;
import api.specification.Specification;
import api.models.request.RegisterUserRequest;

import static io.restassured.RestAssured.given;

public class RegisterUserController {
    @Step("Создать пользователя")
    public static ValidatableResponse postUser(RegisterUserRequest body) {
        return given()
                .spec(Specification.baseSpec())
                .body(body)
                .post(UserEndpoints.REGISTER.getPath())
                .then().log().all();
    }
}
