package com.example.drones.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String imagePath;
    private Integer weight;
    @OneToMany(mappedBy = "medication", cascade = CascadeType.ALL)
    private Set<Drone> drones = new HashSet<>();

    public Medication(Long id, String name, String code, String imagePath, Integer weight) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.imagePath = imagePath;
        this.weight = weight;
    }

    public Medication(Long id, String name, String code, String imagePath) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.imagePath = imagePath;
    }

    public Medication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<Drone> getDrones() {
        return drones;
    }

    public void setDrones(Set<Drone> drones) {
        this.drones = drones;
        for (Drone drone : drones) {
            drone.setMedication(this);
        }
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", weight=" + weight +
                '}';
    }
}
