package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import api.models.response.ApplicationResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.utils.WaitUtils;

import static org.hamcrest.Matchers.*;


public class TMS20Test extends BaseApiAuthTest {
    @Test
    @Tags({@Tag("api"), @Tag("application")})
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("пройти все этапы создания заявки и получить ответ")
    void test() {
        ApplicationRequest app = ApplicationFactory.createValidApplication();
         ApplicationResponse response = ApplicationController.postApplication(app, token)
                 .extract().as(ApplicationResponse.class);
          applicationId = response.getId();
           ApplicationController.putSaveApplication(applicationId, app, token);
            ApplicationEmploymentRequest appStep2 = ApplicationFactory.createValidApplicationStep2();
             ApplicationController.putApplicationEmployment(applicationId, appStep2, token);
              ApplicationLoanRequest loanRequest = ApplicationFactory.createValidLoan();
               ApplicationController.putApplicationLoan(applicationId, loanRequest, token);
                ApplicationController.submitApplication(applicationId, token);
                 WaitUtils.buildAwait()
                   .untilAsserted(() -> ApplicationController.getDecision(applicationId, token)
                        .then()
                        .statusCode(200)
                        .body("status", equalTo("APPROVED")));
                          ApplicationController.getDocument(applicationId, token)
                                  .then()
                                  .statusCode(200)
                                  .body("$", hasSize(2))
                                  .body("status", everyItem(equalTo("READY")))
                                  .body("name", hasItems("Заявление на получение кредита", "Учебный кредитный договор"));
    }
}
