package com.example.testassignmentpotikha.model;

import com.example.testassignmentpotikha.validator.ValidTriangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidTriangle
public class Triangle extends Shape {
    private TriangleType type;

    @Positive(message = "Side a must be positive")
    private Double a;
    @Positive(message = "Side b must be positive")
    private Double b;
    @Positive(message = "Side c must be positive")
    private Double c;

    @Positive(message = "Side lengthOne must be positive")
    private Double lengthOne;
    @Positive(message = "Side lengthTwo must be positive")
    private Double lengthTwo;
    @Positive(message = "Angle must be positive")
    private Double angle;
}
