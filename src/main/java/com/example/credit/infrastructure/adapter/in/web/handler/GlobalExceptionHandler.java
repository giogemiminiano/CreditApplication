package com.example.credit.infrastructure.adapter.in.web.handler;

import com.example.credit.domain.exception.GetCreditApplicationException;
import com.example.credit.domain.exception.InvalidStatusTransitionException;
import com.example.credit.infrastructure.adapter.in.web.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GetCreditApplicationException.class)
    public ResponseEntity<ErrorResponse> applicationNotFound(GetCreditApplicationException exception){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "",
                exception.getMessage(), "");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    public ResponseEntity<ErrorResponse> invalidTransition(InvalidStatusTransitionException exception){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "",
                exception.getMessage(), "");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
