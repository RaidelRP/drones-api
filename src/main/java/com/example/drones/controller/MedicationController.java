package com.example.drones.controller;

import com.example.drones.entity.Medication;
import com.example.drones.repository.MedicationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/medications")
    public ResponseEntity <List<Medication>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/medications/{id}")
    public ResponseEntity<Medication> findOneById(@PathVariable Long id) {
        Optional<Medication> result = repository.findById(id);
        if (result.isEmpty()) // If the id isn't found
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result.get());
    }

    @PostMapping("/medications/new")
    public ResponseEntity<Medication> create(@RequestBody Medication medication) {
        if (medication.getId() != null) // If the new Medication has an id, there should be an error, because the id is autogenerated
            return ResponseEntity.badRequest().build();
        Medication newMedication = repository.save(medication);
        return ResponseEntity.ok(newMedication);
    }

    @PutMapping("/medications/edit/{id}")
    public ResponseEntity<Medication> update(@RequestBody Medication medication, @PathVariable Long id) {

        if (id == null) // If the Medication doesn't have an id, there should be an error. When editing, it should have an id
            return ResponseEntity.badRequest().build();

        Optional<Medication> result = repository.findById(id);

        if (result.isEmpty()) // If the id isn't found
            return ResponseEntity.notFound().build();

        medication.setId(id);

        Medication editedMedication = repository.save(medication);
        return ResponseEntity.ok(editedMedication);
    }

    @DeleteMapping("/medications/delete/{id}")
    public ResponseEntity<Medication> delete(@PathVariable Long id) {
        if (id == null) // If the Medication doesn't have an id, there should be an error. When deleting, it should have an id
            return ResponseEntity.badRequest().build();

        Optional<Medication> result = repository.findById(id);
        if (result.isEmpty()) // If the id isn't found
            return ResponseEntity.notFound().build();

        Medication deletedMedication = result.get();
        repository.deleteById(id);
        return ResponseEntity.ok(deletedMedication);
    }
}
