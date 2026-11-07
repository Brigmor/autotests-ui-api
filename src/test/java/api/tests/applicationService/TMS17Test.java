package api.tests.applicationService;

import api.BaseApiTest;
import api.controllers.ApplicationController;
import api.data.ApplicationFactory;
import api.data.Helpers;
import api.models.request.ApplicationRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TMS17Test extends BaseApiTest {
    @Test
    @Epic("API")
    @Feature("Создание заявки")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание заявки с пустыми обязательными полями")
    void test() {

        String token = Helpers.registerAndLogin();
        ApplicationRequest applicationRequest = ApplicationRequest.builder()
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
        ApplicationController.postApplication(applicationRequest,token)
                .statusCode(422);

    }

}
