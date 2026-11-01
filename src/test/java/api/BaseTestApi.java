package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.example.api.clients.UserApi;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTestApi {

    protected UserApi userApi;

    @BeforeEach
    void setUpApi() {
        RestAssured.filters(new AllureRestAssured());
        userApi = new UserApi();
    }
}
