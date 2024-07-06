package com.example.testassignmentpotikha.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationResponse.ValidationError> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> {
                    String fieldName = error instanceof FieldError
                            ? ((FieldError) error).getField()
                            : error.getObjectName();
                    String errorMessage = error.getDefaultMessage();

                    return new ValidationResponse.ValidationError(fieldName, errorMessage);
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ValidationResponse(errors), HttpStatus.BAD_REQUEST);
    }
}
