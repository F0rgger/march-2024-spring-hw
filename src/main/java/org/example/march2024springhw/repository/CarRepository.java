package org.example.march2024springhw.repository;


import org.example.march2024springhw.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByEnginePowerBetween(int minEnginePower, int maxEnginePower);
}
