package com.example.testassignmentpotikha.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RectangleValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRectangle {
    String message() default "Invalid rectangle data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
