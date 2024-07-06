package com.example.testassignmentpotikha.shapeCalculation;

import java.util.HashMap;
import java.util.Map;

public class ShapeCalculationFactory {
    private static final Map<String, ShapeCalculation> shapeCalculation = new HashMap<String, ShapeCalculation>() {{
        put("circle", new CircleCalculation());
        put("rectangle", new RectangleCalculation());
        put("square", new SquareCalculation());
        put("triangle", new TriangleCalculation());
    }};

    public static ShapeCalculation getShapeCalculation(String shapeName) {
        return shapeCalculation.get(shapeName);
    }
}