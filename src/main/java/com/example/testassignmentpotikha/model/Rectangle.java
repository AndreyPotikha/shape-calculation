package com.example.testassignmentpotikha.model;

import com.example.testassignmentpotikha.validator.ValidRectangle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidRectangle
public class Rectangle extends Shape {
    private RectangleType type;

    @Positive(message = "Side length must be positive")
    private Double length;

    @Positive(message = "Side width must be positive")
    private Double width;

    @Positive(message = "Diagonal must be positive")
    private Double diagonal;
}
