package api.controllers;

import api.endpoints.ApplicationEndpoints;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import api.specification.Specification;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ApplicationController {

    @Step("Создать заявку пользователем")
    public static ValidatableResponse postApplication(ApplicationRequest body) {
        return given()
                .spec(Specification.authSpecification())
                .body(body)
                .post(ApplicationEndpoints.CREATE.getPath())
                .then();
    }
    @Step("Сохранить первый этап заявки")
    public static ValidatableResponse putSaveApplication(String applicationId, ApplicationRequest body) {
        return given()
                .spec(Specification.authSpecification())
                .body(body)
                .when()
                .put(String.format(ApplicationEndpoints.STEP_1.getPath(), applicationId))
                .then();

    }
    @Step("Добавить этап 'работа и доход' к созданию заявки")
    public static ValidatableResponse putApplicationEmployment(String applicationId, ApplicationEmploymentRequest body) {
        return given()
                .spec(Specification.authSpecification())
                .body(body)
                .put(String.format(ApplicationEndpoints.STEP_2.getPath(),applicationId))
                .then();
    }
    @Step("Добавить этап 'параметры кредита' к созданию заявки")
    public static ValidatableResponse putApplicationLoan(String applicationId, ApplicationLoanRequest body) {
        return given()
                .spec(Specification.authSpecification())
                .body(body)
                .put(String.format(ApplicationEndpoints.STEP_3.getPath(),applicationId))
                .then();
    }
    @Step("Отправить заявку на рассмотрение")
    public static ValidatableResponse submitApplication(String applicationId) {
        return given()
                .spec(Specification.authSpecification())
                .header("Idempotency-Key", UUID.randomUUID().toString())
                .when()
                .post(String.format(ApplicationEndpoints.SUBMIT_APPLICATION.getPath(), applicationId))
                .then();
    }
    @Step("Получить решение по заявке")
    public static Response getDecision(String applicationId) {
        return given()
                .spec(Specification.authSpecification())
                .when()
                .get(String.format(ApplicationEndpoints.GET_DECISION.getPath(), applicationId));
    }
    @Step("Скачать документ")
    public static Response downloadDocument(String applicationId, String documentId) {
        return given()
                .spec(Specification.authSpecification())
                .when()
                .get(String.format(ApplicationEndpoints.DOWNLOAD_DOCUMENT.getPath(), applicationId, documentId));
    }
    @Step("Получить список документов на заявку")
    public static Response getDocument(String applicationId) {
        return given()
                .spec(Specification.authSpecification())
                .when()
                .get(String.format(ApplicationEndpoints.GET_DOCUMENT.getPath(), applicationId));

    }
}
