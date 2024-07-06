package com.example.testassignmentpotikha.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TriangleValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTriangle {
    String message() default "Invalid triangle data";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
