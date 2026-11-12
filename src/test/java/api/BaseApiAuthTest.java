package api;

import org.junit.jupiter.api.BeforeEach;
import ru.utils.LoginHelper;

public abstract class BaseApiAuthTest extends BaseApiTest {

    protected static String token;

    @BeforeEach
    public  void setupToken() {
        token = LoginHelper.registerAndLogin();
    }
}
