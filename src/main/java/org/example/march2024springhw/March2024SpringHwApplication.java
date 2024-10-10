package org.example.march2024springhw;

import org.example.march2024springhw.properties.config.FuelTypesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(FuelTypesConfig.class)
public class March2024SpringHwApplication {
    public static void main(String[] args) {
        SpringApplication.run(March2024SpringHwApplication.class, args);
    }
}
