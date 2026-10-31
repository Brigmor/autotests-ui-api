package org.example.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApi {
    protected final RequestSpecification spec;

    protected BaseApi(RequestSpecification spec) {
        this.spec = spec;
    }

    protected RequestSpecification request() {
        return RestAssured.given()
                .spec(spec);
    }
}
