package com.idftechnology.crypto_service.advice;

import lombok.Data;

@Data
public class ResponseError {
    private String logref = "error";
    private String message;

    public ResponseError(String message) {
        this.message = message;
    }
}
