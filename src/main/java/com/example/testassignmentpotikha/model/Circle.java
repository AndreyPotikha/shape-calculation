package com.example.testassignmentpotikha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Shape {
    @Positive(message = "Circumference must be positive")
    private Double circumference;
}
