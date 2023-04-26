package com.example.drones;

import com.example.drones.controller.DroneController;
import com.example.drones.controller.MedicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DronesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DronesApplication.class, args);
        DroneController droneController = context.getBean(DroneController.class);
        MedicationController medicationController = context.getBean(MedicationController.class);

//		Medication medication1 = new Medication(null,"Levodopa-Carbidopa","LEVOCARB","www.google.com/levodopa.jpg",300);
//		medicationController.create(medication1);
//
//		Drone drone1 = new Drone(null, "LightLev", Model.Lightweight,250,50.0, State.IDLE);
//		drone1.setMedication(medication1);
//		droneController.create(drone1);

//		MedicationRepository repository = medicationController.getRepository();
//		var medication = repository.findById(1L).get();
//		medication.setImagePath("www.google.com/levodopa.jpg");
//
//		medicationController.update(medication);

//		droneController.loadedMedication(1L);


    }

}
