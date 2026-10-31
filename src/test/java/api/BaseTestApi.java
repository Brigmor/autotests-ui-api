package api;

import org.example.api.clients.UserApi;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTestApi {

    protected UserApi userApi;

    @BeforeEach
    void setUpApi() {
        userApi = new UserApi();
    }
}
