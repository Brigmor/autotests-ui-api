package api.tests.applicationService;

import api.BaseApiTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.models.request.ApplicationRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS16Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создать заявку без токена авторизации")
    void test() {

        ApplicationRequest applicationRequest = ApplicationFactory.createValidApplication();
        ApplicationController.postApplication(applicationRequest,"")
                .statusCode(401)
                .body("code", Matchers.equalTo("HTTP_ERROR"))
                .body("message",Matchers.equalTo("Authorization required"))
                .body("errors",Matchers.empty());

    }
}
