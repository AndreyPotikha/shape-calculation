package com.example.testassignmentpotikha.validator;

import com.example.testassignmentpotikha.model.Rectangle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.example.testassignmentpotikha.model.RectangleType.ONE_SIDE_AND_DIAGONAL;
import static com.example.testassignmentpotikha.model.RectangleType.TWO_SIDES;

public class RectangleValidator implements ConstraintValidator<ValidRectangle, Rectangle> {

    @Override
    public void initialize(ValidRectangle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Rectangle rectangle, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Invalid data for rectangle");


        if (rectangle.getDiagonal() != null) {
            isValid = (rectangle.getLength() != null
                    || rectangle.getWidth() != null)
                    && rectangle.getDiagonal() != null;

            rectangle.setType(ONE_SIDE_AND_DIAGONAL);

            errorMessage
                    .append(rectangle.getLength() == null ? "; field 'length' is null" : "")
                    .append(rectangle.getWidth() == null ? "; field 'width' is null" : "")
                    .append(rectangle.getDiagonal() == null ? "; field 'diagonal' is null" : "");
        } else if (rectangle.getLength() != null
                || rectangle.getWidth() != null) {
            isValid = rectangle.getWidth() != null
                    && rectangle.getLength() != null;

            rectangle.setType(TWO_SIDES);

            errorMessage
                    .append(rectangle.getLength() == null ? "; field 'length' is null" : "")
                    .append(rectangle.getWidth() == null ? "; field 'width' is null" : "");
        }

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(errorMessage.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
