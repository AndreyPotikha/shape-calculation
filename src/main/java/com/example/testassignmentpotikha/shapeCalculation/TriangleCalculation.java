package com.example.testassignmentpotikha.shapeCalculation;

import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;
import com.example.testassignmentpotikha.model.Triangle;

public class TriangleCalculation implements ShapeCalculation {

    @Override
    public ShapeResult calculate(Shape shape) {
        Triangle triangle = (Triangle) shape;

        switch (triangle.getType()) {
            case THREE_SIDES:
                return calcByThreeSide(triangle);
            case TWO_SIDE_AND_ANGLE:
                return calcBySideAndAngle(triangle);
            default:
                return null;
        }
    }

    private ShapeResult calcByThreeSide(Triangle triangle) {
        Double a = triangle.getA();
        Double b = triangle.getB();
        Double c = triangle.getC();

        double perimeter = a + b + c;
        double s = perimeter / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return new ShapeResult(area, perimeter);
    }

    private ShapeResult calcBySideAndAngle(Triangle triangle) {
        Double a = triangle.getLengthOne();
        Double b = triangle.getLengthTwo();

        double radians = Math.toRadians(triangle.getAngle());
        double area = 0.5 * a * b * Math.sin(radians);
        double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(radians));
        double perimeter = a + b + c;

        return new ShapeResult(area, perimeter);
    }
}
