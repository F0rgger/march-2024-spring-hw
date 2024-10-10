package org.example.march2024springhw.properties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "fuel-types")
public class FuelTypesConfig {
    private Map<String, List<String>> fuelTypes;
}
