package com.example.drones.controller;

import com.example.drones.repository.MedicationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicationController {
    private MedicationRepository repository;

    public MedicationController(MedicationRepository repository) {
        this.repository = repository;
    }

    public MedicationRepository getRepository() {
        return repository;
    }

    public void setRepository(MedicationRepository repository) {
        this.repository = repository;
    }
}
