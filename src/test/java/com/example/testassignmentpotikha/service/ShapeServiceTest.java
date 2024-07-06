package com.example.testassignmentpotikha.service;

import com.example.testassignmentpotikha.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeServiceTest {

    private final ShapeService shapeService = new ShapeService();

    @Test
    public void testCalculateCircle() {
        double circumference = 50;

        double radius = circumference / (2 * Math.PI);
        double expectedArea = Math.PI * radius * radius;

        Circle circle = new Circle(circumference);
        circle.setName("circle");

        ShapeResult calculate = shapeService.calculate(circle);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(circumference, calculate.getPerimeter(), 0.001);
    }

    @Test
    public void testCalculateRectangle() {
        double length = 20;
        double width = 15;
        double diagonal = 25;
        double expectedArea = length * width;
        double expectedPerimeter = 2 * (length + width);

        Rectangle rectangle = new Rectangle(RectangleType.TWO_SIDES, length, width, diagonal);
        rectangle.setName("rectangle");

        ShapeResult calculate = shapeService.calculate(rectangle);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(expectedPerimeter, calculate.getPerimeter(), 0.001);

        rectangle.setType(RectangleType.ONE_SIDE_AND_DIAGONAL);
        calculate = shapeService.calculate(rectangle);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(expectedPerimeter, calculate.getPerimeter(), 0.001);
    }

    @Test
    public void testCalculateTriangle() {
        double a = 5.0;
        double b = 8.0;
        double c = 7.0;
        double angle = 60;

        double expectedPerimeter = a + b + c;
        double s = expectedPerimeter / 2;
        double expectedArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        Triangle triangle = new Triangle(TriangleType.THREE_SIDES, a, b, c, a, b, angle);
        triangle.setName("triangle");
        ShapeResult calculate = shapeService.calculate(triangle);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(expectedPerimeter, calculate.getPerimeter(), 0.001);

        triangle.setType(TriangleType.TWO_SIDE_AND_ANGLE);
        calculate = shapeService.calculate(triangle);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(expectedPerimeter, calculate.getPerimeter(), 0.001);
    }

    @Test
    public void testCalculateSquare() {
        double side = 3.0;
        double expectedArea = side * side;
        double expectedPerimeter = 4 * side;

        Square square = new Square(side);
        square.setName("square");

        ShapeResult calculate = shapeService.calculate(square);

        assertEquals(expectedArea, calculate.getArea(), 0.001);
        assertEquals(expectedPerimeter, calculate.getPerimeter(), 0.001);
    }
}