package com.example.testassignmentpotikha.shapeCalculation;

import com.example.testassignmentpotikha.model.Circle;
import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;

public class CircleCalculation implements ShapeCalculation {

    @Override
    public ShapeResult calculate(Shape shape) {
        Circle circle = (Circle) shape;

        double radius = circle.getCircumference() / (2 * Math.PI);
        double area = Math.PI * radius * radius;

        return new ShapeResult(area, circle.getCircumference());
    }
}
