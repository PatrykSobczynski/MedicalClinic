package com.sobczynski.medical_clinic.model;

import java.sql.Date;

public class Doctor {
    private Long id;
    private String name;
    private String surname;
    private String specialization;
    private int numberOfPhone;

    public Doctor() {
    }

    public Doctor(Long id, String name, String surname, String specialization, int numberOfPhone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.numberOfPhone = numberOfPhone;
    }

    public Doctor(Long id, String surname) {
        this.id = id;
        this.surname = surname;
    }


    public String getFullName() {return name + " " + surname;}
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getNumberOfPhone() { return numberOfPhone; }
    public void setNumberOfPhone(int numberOfPhone) { this.numberOfPhone = numberOfPhone; }
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id;
    }
}

