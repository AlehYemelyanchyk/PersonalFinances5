package com.alehyem.personalfinances.rest;

import com.alehyem.personalfinances.rest.exceptions.PortfolioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PortfolioRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PortfolioErrorResponse> handleException(PortfolioNotFoundException exception) {
        PortfolioErrorResponse error = new PortfolioErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PortfolioErrorResponse> handleException(Exception exception) {
        PortfolioErrorResponse error = new PortfolioErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
