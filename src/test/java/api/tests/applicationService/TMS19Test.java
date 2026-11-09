package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationRequest;
import api.models.request.ApplicationLoanRequest;
import api.models.response.ApplicationResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TMS19Test extends BaseApiAuthTest {

    @Test
    @Tags({@Tag("API")})
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавить этап 'параметры кредита' в заявку")
    void test() {
        ApplicationRequest app = ApplicationFactory.createValidApplication();
        ApplicationResponse response = ApplicationController.postApplication(app,token)
                .extract().as(ApplicationResponse.class);
        String appId = response.getId();
        ApplicationEmploymentRequest appStep2 = ApplicationFactory.createValidApplicationStep2();
        ApplicationController.putApplicationEmployment(appId,appStep2,token);
        ApplicationLoanRequest loanRequest = ApplicationFactory.createValidLoan();
        ApplicationController.putApplicationLoan(appId,loanRequest,token).extract();


    }
}
