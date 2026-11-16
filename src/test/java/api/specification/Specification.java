
package api.specification;

import api.helpers.LoginHelper;
import config.Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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

    public static RequestSpecification authSpecification() {
        return new RequestSpecBuilder()
                .setAuth(RestAssured.oauth2(LoginHelper.registerAndLogin()))
                .setBaseUri(Config.CONFIG_APP.applicationServiceUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
