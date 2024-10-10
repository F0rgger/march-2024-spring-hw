package org.example.march2024springhw.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(name = "engine_power", nullable = false)
    private int enginePower;

    @Column(nullable = false)
    private int torque;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;
}
