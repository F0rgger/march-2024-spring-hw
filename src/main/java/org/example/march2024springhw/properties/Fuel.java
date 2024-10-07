package org.example.march2024springhw.properties;

import lombok.Data;

import java.util.List;

@Data
public class Fuel {
    private String name;
    private List<String> types;
}
