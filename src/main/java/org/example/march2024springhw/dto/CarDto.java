package org.example.march2024springhw.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarDto {

    private Long id;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Min(value = 1, message = "Engine power must be greater than 0")
    private int enginePower;

    @Min(value = 1, message = "Torque must be greater than 0")
    private int torque;

    @NotBlank(message = "Fuel type cannot be blank")
    private String fuelType;
}
