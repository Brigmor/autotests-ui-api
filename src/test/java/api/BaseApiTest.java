package api;
import api.specification.CustomTpl;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseApiTest {

    @BeforeAll
    public static void setUpApi() {
                RestAssured.filters(CustomTpl.customLogFilter().getFilter());
    }
}