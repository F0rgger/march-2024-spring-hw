package org.example.march2024springhw.properties.conntrollers;

import org.example.march2024springhw.entity.Maintenance;
import org.example.march2024springhw.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @GetMapping
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.findAll();
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(@PathVariable String id) {
        return maintenanceService.findById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable String id, @RequestBody Maintenance maintenance) {
        return maintenanceService.update(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable String id) {
        maintenanceService.deleteById(id);
    }
}
