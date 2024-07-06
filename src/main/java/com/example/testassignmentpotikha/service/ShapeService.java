package com.example.testassignmentpotikha.service;

import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;
import com.example.testassignmentpotikha.shapeCalculation.ShapeCalculation;
import com.example.testassignmentpotikha.shapeCalculation.ShapeCalculationFactory;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {
    public ShapeResult calculate(Shape shape) {
        ShapeCalculation shapeCalculation = ShapeCalculationFactory.getShapeCalculation(shape.getName());

        if (shapeCalculation == null)
            throw new IllegalArgumentException("Unknown shape " + shape.getName());

        return shapeCalculation.calculate(shape);
    }
}
