package org.example.march2024springhw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    public Maintenance findById(String id) {
        return maintenanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Maintenance not found"));
    }

    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance update(String id, Maintenance maintenance) {
        Maintenance existingMaintenance = findById(id);
        existingMaintenance.setName(maintenance.getName());
        existingMaintenance.setDescription(maintenance.getDescription());
        existingMaintenance.setPrice(maintenance.getPrice());
        return maintenanceRepository.save(existingMaintenance);
    }

    public void deleteById(String id) {
        maintenanceRepository.deleteById(id);
    }
}
