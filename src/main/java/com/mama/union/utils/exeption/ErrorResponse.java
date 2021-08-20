package com.mama.union.utils.exeption;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {

    private String message;
    private String user;
    private String date;
    private String path;

    private Map<String, String> body;

    public ErrorResponse (String message) {
        this.message = message;
    }

    public ErrorResponse(String message, Map<String, String> body) {
        this.message = message;
        this.body = body;
    }

    public ErrorResponse(String message, String user, String date, String path, Map<String, String> body) {
        this.message = message;
        this.user = user;
        this.date = date;
        this.path = path;
        this.body = body;
    }
}
