package org.example.api.specification;

import org.example.config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
    public static RequestSpecification baseSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(Config.getUserServiceUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }


}
