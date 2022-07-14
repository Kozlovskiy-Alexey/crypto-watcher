package com.idftechnology.crypto_service.advice;

import lombok.Data;

@Data
public class SingleValidateException extends IllegalArgumentException {

    private final ResponseError responseError;

    public SingleValidateException(ResponseError responseError) {
        this.responseError = responseError;
    }
}
