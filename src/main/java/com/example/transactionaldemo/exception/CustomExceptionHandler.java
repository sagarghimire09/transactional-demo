package com.example.transactionaldemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomError> handleGenericException(Exception ex) {
        CustomError customError = CustomError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(Timestamp.from(Instant.now()))
                .build();
        return new ResponseEntity<>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
