package com.example.drones.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String imagePath;
    @OneToMany(mappedBy = "medication")
    private List<Drone> drones;

    public Medication(Long id, String name, String code, String imagePath) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.imagePath = imagePath;
    }

    public Medication(Long id, String name, String code, String imagePath, List<Drone> drones) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.imagePath = imagePath;
        this.drones = drones;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public void setDrones(List<Drone> drones) {
        this.drones = drones;
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

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
