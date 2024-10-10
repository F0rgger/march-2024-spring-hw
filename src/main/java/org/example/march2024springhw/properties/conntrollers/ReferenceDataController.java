package org.example.march2024springhw.properties.conntrollers;

import lombok.RequiredArgsConstructor;
import org.example.march2024springhw.properties.config.FuelTypesConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReferenceDataController {

    @Value("${engine-types.types}")
    private final List<String> engineTypes;
    private final FuelTypesConfig fuelTypesConfig;

    @GetMapping("/engine-types")
    public List<String> getEngineTypes() {
        return engineTypes;
    }

    @GetMapping("/fuel-types")
    public Map<String, List<String>> getFuelTypes() {
        return fuelTypesConfig.getFuelTypes();
    }

    @GetMapping("/fuel-types/{fuelName}")
    public ResponseEntity<Map<String, List<String>>> getFuelType(@PathVariable String fuelName) {
        Map<String, List<String>> fuelTypes = fuelTypesConfig.getFuelTypes();
        if (fuelTypes.containsKey(fuelName)) {
            return ResponseEntity.ok(Collections.singletonMap(fuelName, fuelTypes.get(fuelName)));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
