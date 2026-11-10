package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationLoanRequest;
import api.models.request.ApplicationRequest;
import api.models.response.ApplicationResponse;
import org.junit.jupiter.api.Test;
import utils.WaitUtils;

import static org.hamcrest.Matchers.*;


public class TMS20Test extends BaseApiAuthTest {
    @Test
    void test() {
        ApplicationRequest app = ApplicationFactory.createValidApplication();
         ApplicationResponse response = ApplicationController.postApplication(app, token)
                 .extract().as(ApplicationResponse.class);
          String appId = response.getId();
           ApplicationController.putSaveApplication(appId, app, token);
            ApplicationEmploymentRequest appStep2 = ApplicationFactory.createValidApplicationStep2();
             ApplicationController.putApplicationEmployment(appId, appStep2, token);
              ApplicationLoanRequest loanRequest = ApplicationFactory.createValidLoan();
               ApplicationController.putApplicationLoan(appId, loanRequest, token);
                ApplicationController.submitApplication(appId, token);
                 WaitUtils.buildAwait()
                   .untilAsserted(() -> ApplicationController.getDecision(appId, token)
                        .then()
                        .statusCode(200)
                        .body("status", equalTo("APPROVED")));
                          ApplicationController.getDocument(appId, token)
                                  .then()
                                  .statusCode(200)
                                  .body("$", hasSize(2))
                                  .body("status", everyItem(equalTo("READY")))
                                  .body("name", hasItems(
                                          "Заявление на получение кредита",
                                          "Учебный кредитный договор"
                                  ));
    }
}
