package com.project.hospital.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "departments")
    private Set<Doctor> doctors = new HashSet<>();

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Department(String name, String description, Set<Doctor> doctors) {
        this.name = name;
        this.description = description;
        this.doctors = doctors;
    }

    public Department() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
