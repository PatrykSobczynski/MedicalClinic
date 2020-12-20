package com.sobczynski.medical_clinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Visit {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateVisit;
    private Patient patient;
    private Doctor doctor;

    public Visit() {
    }

    public Visit(Long id, Date dateVisit, Patient patient, Doctor doctor) {
        this.id = id;
        this.dateVisit = dateVisit;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getDate() { return dateVisit; }
    public void setDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.dateVisit = dateFormat.parse(String.valueOf(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
