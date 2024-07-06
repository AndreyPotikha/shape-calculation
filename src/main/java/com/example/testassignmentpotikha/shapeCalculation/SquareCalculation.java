package com.example.testassignmentpotikha.shapeCalculation;

import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;
import com.example.testassignmentpotikha.model.Square;

public class SquareCalculation implements ShapeCalculation {

    @Override
    public ShapeResult calculate(Shape shape) {
        Square square = (Square) shape;

        double side = square.getSide();

        double area = side * side;
        double perimeter = 4 * side;

        return new ShapeResult(area, perimeter);
    }
}
