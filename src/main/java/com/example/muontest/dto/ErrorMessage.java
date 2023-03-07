package com.example.muontest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private Map<String, String> errors;

    public ErrorMessage(int statusCode, Date timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorMessage(int statusCode, Date timestamp, String message, Map<String, String> errors) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
