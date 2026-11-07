package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TMS15Test extends BaseApiAuthTest {

    @Test
    @Tag("API")
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создать заявку с этапом персональные данные")
    void test() {
        ApplicationRequest applicationRequest = ApplicationFactory.createValidApplication();
        ApplicationController.postApplication(applicationRequest, token)
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("userId", Matchers.notNullValue())
                .body("status", Matchers.equalTo("DRAFT"))
                .body("createdAt", Matchers.notNullValue())
                .body("decidedAt", Matchers.nullValue())
                .body("rejectionReason", Matchers.nullValue())
                .body("step1", Matchers.nullValue())
                .body("step2", Matchers.nullValue())
                .body("step3", Matchers.nullValue())
                .body("documents", Matchers.empty());
    }
}
