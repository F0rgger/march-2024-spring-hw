package org.example.march2024springhw.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FuelTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FuelTypeConstraint {
    String message() default "Invalid fuel type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
