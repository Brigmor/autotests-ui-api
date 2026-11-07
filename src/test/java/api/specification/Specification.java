package api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.bank.config.Config;

public class Specification {

    public static RequestSpecification baseUserService() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.CONFIG_APP.userServiceUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static RequestSpecification baseApplicationService() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.CONFIG_APP.applicationServiceUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}