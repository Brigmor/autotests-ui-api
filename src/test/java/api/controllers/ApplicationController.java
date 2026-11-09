package api.controllers;

import api.endpoints.ApplicationEndpoints;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import api.models.request.ApplicationEmploymentRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApplicationController {

    @Step("Создать заявку пользователем")
    public static ValidatableResponse postApplication(ApplicationRequest body, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth()
                .oauth2(token)
                .body(body)
                .log().body()
                .post(ApplicationEndpoints.CREATE.getPath())
                .then().log().all();
    }
    @Step("Добавить этап 'работа и доход' к созданию заявки")
    public static ValidatableResponse putApplicationEmployment(String applicationId, ApplicationEmploymentRequest body, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth()
                .oauth2(token)
                .body(body)
                .log().body()
                .put(String.format(ApplicationEndpoints.STEP_2.getPath(),applicationId))
                .then().log().all();
    }
    @Step("Добавить этап 'параметры кредита' к созданию заявки")
    public static ValidatableResponse putApplicationLoan(String applicationId, ApplicationLoanRequest body, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth()
                .oauth2(token)
                .body(body)
                .log().body()
                .put(String.format(ApplicationEndpoints.STEP_3.getPath(),applicationId))
                .then().log().all();
    }
}
