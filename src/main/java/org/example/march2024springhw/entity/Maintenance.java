package org.example.march2024springhw.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "maintenances")
public class Maintenance {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;

    // Getters and Setters
}
