package com.project.hospital.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class MedicalRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private TimeDate td;

    private String treatment;
    private String medications;
    private String results;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalRecords() {
    }

    public MedicalRecords(TimeDate td,String treatment, String medications, String results, Patient patient) {
        this.td = td;
        this.treatment = treatment;
        this.medications = medications;
        this.results = results;
        this.patient = patient;
    }


    public int getId() {
        return id;
    }

    public TimeDate getTd() {
        return td;
    }

    public void setTd(TimeDate td) {
        this.td = td;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
