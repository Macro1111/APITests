package com.globan.automation.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;

public class RequestBuild{

    public static <T> T waitFor(String baseUrl, String URLSuffix, long timeoutSeconds, long pollMillis, Class<T> clazz) {
        return org.awaitility.Awaitility.await()
                .atMost(timeoutSeconds, java.util.concurrent.TimeUnit.SECONDS)
                .pollInterval(pollMillis, java.util.concurrent.TimeUnit.MILLISECONDS)
                .until(() -> {
                    Response response = response(baseUrl, URLSuffix);
                    return response.getStatusCode() == 200 ? response.as(clazz) : null;
                }, java.util.Objects::nonNull);
    }

    public static Response response(String URLBase , String URLSuffix){
        return RestAssured
                .given().baseUri(URLBase)
                .header("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get(URLSuffix);
    }

    public static Response createResponse(String URLBase , String URLSuffix, Object object){
        return RestAssured
                .given().baseUri(URLBase)
                .header("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .body(object)
                .post(URLSuffix);
    }
}
