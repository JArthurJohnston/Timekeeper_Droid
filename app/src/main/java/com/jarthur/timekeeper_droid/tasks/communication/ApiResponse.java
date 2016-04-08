package com.jarthur.timekeeper_droid.tasks.communication;

/**
 * Created by arthur on 4/6/16.
 */

public class ApiResponse {

    private final int code;
    private final String body;

    public ApiResponse(int code, String body){

        this.code = code;
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }
}