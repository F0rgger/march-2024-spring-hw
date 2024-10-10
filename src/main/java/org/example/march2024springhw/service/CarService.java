package org.example.march2024springhw.service;

import org.example.march2024springhw.dto.CarDto;
import org.example.march2024springhw.entity.Car;
import org.example.march2024springhw.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CarDto getCarById(Long id) {
        return carRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public CarDto createCar(CarDto carDto) {
        Car car = convertToEntity(carDto);
        return convertToDto(carRepository.save(car));
    }

    public CarDto updateCar(Long id, CarDto carDto) {
        return carRepository.findById(id)
                .map(existingCar -> {
                    existingCar.setModel(carDto.getModel());
                    existingCar.setEnginePower(carDto.getEnginePower());
                    existingCar.setTorque(carDto.getTorque());
                    existingCar.setFuelType(carDto.getFuelType());
                    return convertToDto(carRepository.save(existingCar));
                })
                .orElse(null);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private CarDto convertToDto(Car car) {
        return modelMapper.map(car, CarDto.class);
    }

    private Car convertToEntity(CarDto carDto) {
        return modelMapper.map(carDto, Car.class);
    }
}
