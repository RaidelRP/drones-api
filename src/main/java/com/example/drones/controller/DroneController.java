package com.example.drones.controller;

import com.example.drones.repository.DroneRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {
    private DroneRepository repository;

    public DroneController(DroneRepository repository) {
        this.repository = repository;
    }

    public DroneRepository getRepository() {
        return repository;
    }

    public void setRepository(DroneRepository repository) {
        this.repository = repository;
    }
}
