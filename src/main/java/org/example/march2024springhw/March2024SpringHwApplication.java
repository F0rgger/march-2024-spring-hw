package org.example.march2024springhw;

import org.example.march2024springhw.dto.CarDto;
import org.example.march2024springhw.entity.Car;
import org.example.march2024springhw.entity.User;
import org.example.march2024springhw.properties.config.FuelTypesConfig;
import org.example.march2024springhw.repository.OwnerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.server.ResponseStatusException;


@SpringBootApplication
@EnableConfigurationProperties(FuelTypesConfig.class)
public class March2024SpringHwApplication {
    public static void main(String[] args) {
        SpringApplication.run(March2024SpringHwApplication.class, args);
    }
}

public Car createCar(CarDto carDto) {
    OwnerRepository ownerRepository;
    User owner = ownerRepository.findByUsername(carDto.getOwnerUsername());
    if (owner == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Owner does not exist");
    }
    Car car = new Car();
    car.setModel(carDto.getModel());
    car.setEnginePower(carDto.getEnginePower());
    car.setOwner(owner);
    return carRepository.save(car);
}
