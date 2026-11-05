package api.specification;

import ru.bank.config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {

       public static RequestSpecification UserSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.getUserServiceUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static  RequestSpecification ApplicationSpec() {
           return new RequestSpecBuilder()
                   .setBaseUri(Config.getApplicationServiceUrl())
                   .setContentType(ContentType.JSON)
                   .setAccept(ContentType.JSON)
                   .build();
    }
}