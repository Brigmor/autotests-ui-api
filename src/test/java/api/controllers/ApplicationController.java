package api.controllers;

import api.endpoints.ApplicationEndpoints;
import api.models.request.ApplicationRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApplicationController {

    @Step("Создать заявку пользователем")
    public static ValidatableResponse postApplication(ApplicationRequest body, String token) {
        return  given()
                .spec(Specification.ApplicationSpec())
                .auth()
                .oauth2(token)
                .body(body)
                .log().body()
                .post(ApplicationEndpoints.CREATE.getPath())
                .then().log().all();
    }
}
