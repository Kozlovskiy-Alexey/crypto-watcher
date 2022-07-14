package com.idftechnology.crypto_service.advice;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ResponseError> badRequest(SingleValidateException e) {
        return new ResponseEntity<>(e.getResponseError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseError> identifierGeneration(IdentifierGenerationException e) {
        return new ResponseEntity<>(new ResponseError("Message body fields should not be null"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseError> httpMessageNotReadable(HttpMessageNotReadableException e)  {
        return new ResponseEntity<>(new ResponseError("Json format is wrong."), HttpStatus.BAD_REQUEST);
    }
}
