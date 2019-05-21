package com.swedbank.game.model;

/**
 * Created by maryam on 10/5/2018.
 */
public class Response {
    private String code;
    private String message;

    public Response() {}

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
