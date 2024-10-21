package org.example.march2024springhw.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "owner")
    private Set<Car> cars;

    // Getters and Setters
}
