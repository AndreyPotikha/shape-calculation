package com.example.testassignmentpotikha.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationResponse {
    private List<ValidationError> errors;

    public ValidationResponse(List<ValidationError> errors) {
        this.errors = errors;
    }

    @Data
    @AllArgsConstructor
    public static class ValidationError {
        private String field;
        private String message;
    }
}
