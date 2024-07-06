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
public class Square extends Shape {
    @Positive(message = "Side must be positive")
    private Double side;
}
