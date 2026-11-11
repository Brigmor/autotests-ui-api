package api;

import api.specification.CustomTpl;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.DatabaseHelper;

public abstract class BaseApiTest {

    @BeforeAll
    public static void setUpApi() {
        RestAssured.reset();
        RestAssured.filters(CustomTpl.customLogFilter().getFilter());
    }

    protected String applicationId;

    @AfterEach
    void tearDown() {
        if (applicationId != null) {
            DatabaseHelper.deleteApplication(applicationId);
            applicationId = null;
        }
    }
}