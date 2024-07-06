package com.example.testassignmentpotikha.validator;

import com.example.testassignmentpotikha.model.Triangle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.example.testassignmentpotikha.model.TriangleType.THREE_SIDES;
import static com.example.testassignmentpotikha.model.TriangleType.TWO_SIDE_AND_ANGLE;

public class TriangleValidator implements ConstraintValidator<ValidTriangle, Triangle> {

    @Override
    public void initialize(ValidTriangle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Triangle triangle, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Invalid data for triangle");


        if (triangle.getA() != null
                || triangle.getB() != null
                || triangle.getC() != null) {
            isValid = triangle.getA() != null
                    && triangle.getB() != null
                    && triangle.getC() != null;

            triangle.setType(THREE_SIDES);

            errorMessage
                    .append(triangle.getA() == null ? "; field 'a' is null" : "")
                    .append(triangle.getB() == null ? "; field 'b' is null" : "")
                    .append(triangle.getC() == null ? "; field 'c' is null" : "");
        } else if (triangle.getLengthOne() != null
                || triangle.getLengthTwo() != null
                || triangle.getAngle() != null) {
            isValid = triangle.getLengthOne() != null
                    && triangle.getLengthTwo() != null
                    && triangle.getAngle() != null;

            triangle.setType(TWO_SIDE_AND_ANGLE);

            errorMessage
                    .append(triangle.getLengthOne() == null ? "; field 'lengthOne' is null" : "")
                    .append(triangle.getLengthTwo() == null ? "; field 'lengthTwo' is null" : "")
                    .append(triangle.getAngle() == null ? "; field 'angle' is null" : "");
        }

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
