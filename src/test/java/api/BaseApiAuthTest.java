package api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.LoginHelper;

public abstract class BaseApiAuthTest extends BaseApiTest {

    protected static String token;

    @BeforeEach
    public  void setupToken() {
        token = LoginHelper.registerAndLogin();
    }
}
