package com.globan.automation.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.apache.http.entity.ContentType;

/**
 * Utility class for building and sending HTTP requests using RestAssured.
 * Provides methods to create requests, wait for responses, and handle logging.
 */

public class RequestBuild{


    /**
     * Waits for a response from the specified URL and returns the response as an object of the specified class.
     *
     * @param baseUrl       The base URL for the request.
     * @param URLSuffix     The suffix to append to the base URL.
     * @param timeoutSeconds The maximum time to wait for a response, in seconds.
     * @param pollMillis    The interval at which to poll for a response, in milliseconds.
     * @param clazz         The class type to which the response should be converted.
     * @param <T>           The type of the response object.
     * @return The response object of type T, or null if the status code is not 200.
     */
    public static <T> T waitFor(String baseUrl, String URLSuffix, long timeoutSeconds, long pollMillis, Class<T> clazz) {
        return org.awaitility.Awaitility.await()
                .atMost(timeoutSeconds, java.util.concurrent.TimeUnit.SECONDS)
                .pollInterval(pollMillis, java.util.concurrent.TimeUnit.MILLISECONDS)
                .until(() -> {
                    Response response = response(baseUrl, URLSuffix);
                    return response.getStatusCode() == 200 ? response.as(clazz) : null;
                }, java.util.Objects::nonNull);
    }


    /**
     * Sends a GET request to the specified URL and returns the response.
     *
     * @param URLBase   The base URL for the request.
     * @param URLSuffix The suffix to append to the base URL.
     * @return The response from the GET request.
     */
    public static Response response(String URLBase , String URLSuffix){
        return RestAssured
                .given().baseUri(URLBase)
                .header("Content-Type", ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .when()
                .get(URLSuffix);
    }


    /**
     * Creates a POST request with the specified object as the body and returns the response.
     *
     * @param URLBase   The base URL for the request.
     * @param URLSuffix The suffix to append to the base URL.
     * @param object    The object to be sent in the request body.
     * @return The response from the POST request.
     */
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
