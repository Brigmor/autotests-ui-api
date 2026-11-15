package api.tests.applicationService;

import api.BaseApiTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import utils.WaitUtils;

import static org.hamcrest.Matchers.*;


public class TMS20Test extends BaseApiTest {

    private ApplicationRequest app;

    @Test
    @Tags({@Tag("api"), @Tag("application")})
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("пройти все этапы создания заявки и получить ответ")
    void test() {
        step1();
        step2(); //TODO: Добавить логи в степы
        ...
            ApplicationEmploymentRequest appStep2 = ApplicationFactory.createValidApplicationStep2();
        ApplicationController.putApplicationEmployment(applicationId, appStep2);
              ApplicationLoanRequest loanRequest = ApplicationFactory.createValidLoan();
        ApplicationController.putApplicationLoan(applicationId, loanRequest);
        ApplicationController.submitApplication(applicationId);
                 WaitUtils.buildAwait()
                         .untilAsserted(() -> ApplicationController.getDecision(applicationId)
                        .then()
                        .statusCode(200)
                        .body("status", equalTo("APPROVED")));
        ApplicationController.getDocument(applicationId)
                                  .then()
                                  .statusCode(200)
                                  .body("$", hasSize(2))
                                  .body("status", everyItem(equalTo("READY")))
                                  .body("name", hasItems("Заявление на получение кредита", "Учебный кредитный договор"));
    }

    @Step("Шаг 1. Создание черновика заявки")
    private void step1() {
        app = ApplicationFactory.createValidApplication();
        applicationId = ApplicationController.postApplication(app).extract().path("id");
    }

    @Step("Шаг 2. Заполнить первый шаг заявки")
    private void step2() {
        ApplicationController.putSaveApplication(applicationId, app);
    }
}
