package api.controllers;

import api.endpoints.ApplicationEndpoints;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import api.models.request.ApplicationEmploymentRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.UUID;

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
    @Step("Сохранить первый этап заявки")
    public static ValidatableResponse putSaveApplication(
            String applicationId,
            ApplicationRequest body,
            String token
    ) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth().oauth2(token)
                .body(body)
                .when()
                .put(String.format(ApplicationEndpoints.STEP_1.getPath(), applicationId))
                .then()
                .log().all();
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
    @Step("Отправить заявку на рассмотрение")
    public static ValidatableResponse submitApplication(String applicationId, String token
    ) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth().oauth2(token)
                .header("Idempotency-Key", UUID.randomUUID().toString())
                .when()
                .post(String.format(ApplicationEndpoints.SUBMIT_APPLICATION.getPath(), applicationId))
                .then()
                .log().all();
    }
    @Step("Получить решение по заявке")
    public static Response getDecision(String applicationId, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth().oauth2(token)
                .when()
                .get(String.format(ApplicationEndpoints.GET_DECISION.getPath(), applicationId))
                .prettyPeek();
    }
    @Step("Скачать документ")
    public static Response downloadDocument(String applicationId, String documentId, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth()
                .oauth2(token)
                .when()
                .get(String.format(ApplicationEndpoints.DOWNLOAD_DOCUMENT.getPath(), applicationId, documentId))
                .prettyPeek();
    }
    @Step("Получить список документов на заявку")
    public static Response getDocument(String applicationId, String token) {
        return given()
                .spec(Specification.baseApplicationService())
                .auth()
                .oauth2(token)
                .when()
                .get(String.format(ApplicationEndpoints.GET_DOCUMENT.getPath(),applicationId))
                .prettyPeek();

    }
}
