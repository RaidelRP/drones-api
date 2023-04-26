package com.example.drones;

import com.example.drones.controller.DroneController;
import com.example.drones.controller.MedicationController;
import com.example.drones.entity.Drone;
import com.example.drones.entity.Medication;
import com.example.drones.entity.Model;
import com.example.drones.entity.State;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class DronesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DronesApplication.class, args);
		DroneController droneController = context.getBean(DroneController.class);
		MedicationController medicationController = context.getBean(MedicationController.class);

//		Medication medication1 = new Medication(null,"Levodopa-Carbidopa","LEVOCARB","www.google.com/levodopa.jpg");
//		medicationController.create(medication1);
//
//		Drone drone1 = new Drone(null, "LightLev", Model.Lightweight,250,50.0, State.IDLE);
//		drone1.setMedication(medication1);
//		droneController.create(drone1);

	}

}
