package org.example.march2024springhw.properties.conntrollers;



import lombok.RequiredArgsConstructor;
import org.example.march2024springhw.entity.Car;
import org.example.march2024springhw.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars(
            @RequestParam(value = "minEnginePower", required = false) Integer minEnginePower,
            @RequestParam(value = "maxEnginePower", required = false) Integer maxEnginePower
    ) {
        if (minEnginePower != null && maxEnginePower != null) {
            return carRepository.findByEnginePowerBetween(minEnginePower, maxEnginePower);
        }
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carRepository.findById(id)
                .map(car -> ResponseEntity.ok().body(car))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setModel(updatedCar.getModel());
                    car.setEnginePower(updatedCar.getEnginePower());
                    car.setTorque(updatedCar.getTorque());
                    carRepository.save(car);
                    return ResponseEntity.ok().body(car);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        return carRepository.findById(id)
                .map(car -> {
                    carRepository.delete(car);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
