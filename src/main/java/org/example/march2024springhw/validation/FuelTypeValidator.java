package org.example.march2024springhw.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class FuelTypeValidator implements ConstraintValidator<FuelTypeConstraint, String> {

    @Value("${fuel-types.types}")
    private List<String> validFuelTypes;

    @Override
    public boolean isValid(String fuelType, ConstraintValidatorContext context) {
        return validFuelTypes.contains(fuelType);
    }
}
