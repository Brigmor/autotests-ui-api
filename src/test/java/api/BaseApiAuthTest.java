package api;

import org.junit.jupiter.api.BeforeAll;
import utils.LoginHelper;

public abstract class BaseApiAuthTest extends BaseApiTest {

    protected static String token;

    @BeforeAll
    public static void setupToken() {
        token = LoginHelper.registerAndLogin();
    }
}
