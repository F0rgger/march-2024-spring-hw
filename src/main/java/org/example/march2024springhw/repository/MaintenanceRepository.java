package org.example.march2024springhw.repository;

import org.example.march2024springhw.entity.Maintenance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaintenanceRepository extends MongoRepository<Maintenance, String> {
}
