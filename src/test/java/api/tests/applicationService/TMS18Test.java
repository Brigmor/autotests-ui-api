package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationEmploymentRequest;
import api.models.request.ApplicationRequest;
import api.models.response.ApplicationResponse;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TMS18Test extends BaseApiAuthTest {

    @Test
    @Tags({@Tag("api"), @Tag("application")})
    @Feature("Добавить 2 шаг к созданию заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавить 2 шаг 'работа и доход' к созданной заявке")
    void test() {

        ApplicationRequest app = ApplicationFactory.createValidApplication();
        ApplicationResponse response = ApplicationController.postApplication(app,token)
                .extract().as(ApplicationResponse.class);
        String appId = response.getId();
        ApplicationEmploymentRequest appStep2 = ApplicationFactory.createValidApplicationStep2();
        ApplicationController.putApplicationEmployment(appId,appStep2,token)
                .statusCode(200)
                .body("id", Matchers.equalTo(appId))
                .body("userId",Matchers.notNullValue())
                .body("status",Matchers.equalTo("DRAFT"))
                .body("createdAt",Matchers.notNullValue())
                .body("decidedAt",Matchers.nullValue())
                .body("rejectionReason",Matchers.nullValue())
                .body("step1",Matchers.nullValue())
                .body("step2.employmentType",Matchers.equalTo(appStep2.getEmploymentType()))
                .body("step2.employer",Matchers.equalTo(appStep2.getEmployer()))
                .body("step2.position",Matchers.equalTo(appStep2.getPosition()))
                .body("step2.experienceMonths",Matchers.equalTo(appStep2.getExperienceMonths()))
                .body("step2.monthlyIncome",Matchers.equalTo(appStep2.getMonthlyIncome()))
                .body("step2.monthlyExpenses",Matchers.equalTo(appStep2.getMonthlyExpenses()))
                .body("step2.additionalIncome",Matchers.equalTo(appStep2.getAdditionalIncome()));







    }
}
