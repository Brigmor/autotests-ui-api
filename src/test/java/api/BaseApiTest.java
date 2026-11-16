package api;

import api.helpers.LoginHelper;
import api.specification.CustomTpl;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static db.SqlExecutor.deleteApplication;

public abstract class BaseApiTest {

    protected String applicationId;

    @BeforeAll
    public static void setUpApi() {
        RestAssured.reset();
        RestAssured.filters(CustomTpl.customLogFilter().getFilter());
    }

    @AfterEach
    void tearDown() {
        if (applicationId != null) {
            deleteApplication(applicationId);
            applicationId = null;
        }
        LoginHelper.clearToken();
    }
}
