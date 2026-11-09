package api.tests.applicationService;

import api.BaseApiAuthTest;
import api.controllers.ApplicationController;
import api.models.request.ApplicationRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TMS17Test extends BaseApiAuthTest {

    @Test
    @Tags({@Tag("API"),@Tag("Application")})
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание заявки с пустыми обязательными полями")
    void test() {
        ApplicationController.postApplication(getApplicationRequest(), token)
                .statusCode(422);
    }

    private ApplicationRequest getApplicationRequest() {
        return ApplicationRequest.builder()
                .firstName("")
                .lastName("")
                .birthDate("")
                .gender("")
                .departmentCode("")
                .passportNumber("")
                .passportSeries("")
                .issueDate("")
                .registrationAddress("")
                .middleName("")
                .build();
    }
}