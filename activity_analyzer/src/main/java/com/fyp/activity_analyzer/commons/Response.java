package com.fyp.activity_analyzer.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haier_1 on 5/16/2017.
 */
public class Response {

    int statusCode;
    String description;
    Map<String,Object> responseBody = new HashMap<>();

    public Response() {
    }

    public Response(int statusCode, String description, Map<String, Object> responseBody) {
        this.statusCode = statusCode;
        this.description = description;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Map<String, Object> responseBody) {
        this.responseBody = responseBody;
    }

}
