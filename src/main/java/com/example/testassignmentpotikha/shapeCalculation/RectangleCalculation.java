package com.example.testassignmentpotikha.shapeCalculation;

import com.example.testassignmentpotikha.model.Rectangle;
import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;

public class RectangleCalculation implements ShapeCalculation {

    @Override
    public ShapeResult calculate(Shape shape) {
        Rectangle rectangle = (Rectangle) shape;

        switch (rectangle.getType()) {
            case TWO_SIDES:
                return calcByTwoSide(rectangle);
            case ONE_SIDE_AND_DIAGONAL:
                return calcByOneSideAndDiagonal(rectangle);
            default:
                return null;
        }
    }

    private ShapeResult calcByTwoSide(Rectangle rectangle) {
        double width = rectangle.getWidth();
        double length = rectangle.getLength();

        double area = length * width;
        double perimeter = 2 * (length + width);

        return new ShapeResult(area, perimeter);
    }

    private ShapeResult calcByOneSideAndDiagonal(Rectangle rectangle) {
        double oneSide = rectangle.getWidth() != null ? rectangle.getWidth() : rectangle.getLength();
        double diagonal = rectangle.getDiagonal();

        double twoSide = Math.sqrt(diagonal * diagonal - oneSide * oneSide);

        double area = oneSide * twoSide;
        double perimeter = 2 * (oneSide + twoSide);

        return new ShapeResult(area, perimeter);
    }
}
