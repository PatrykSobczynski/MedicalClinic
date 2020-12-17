package com.sobczynski.medical_clinic.model;

public class Patient {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String disease; // Dolegliwość
    private String diseaseDescribe;
    private int bedNumber;

    public Patient() {
    }

    public Patient(String name, String surname, int age, String disease, String diseaseDescribe, int bedNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.disease = disease;
        this.diseaseDescribe = diseaseDescribe;
        this.bedNumber = bedNumber;
    }

    public Patient(Long id, String name, String surname, int age, String disease, String diseaseDescribe, int bedNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.disease = disease;
        this.diseaseDescribe = diseaseDescribe;
        this.bedNumber = bedNumber;
    }

    public void setBedNumber(int bedNumber) { this.bedNumber = bedNumber; }
    public int getBedNumber() { return bedNumber; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDetails() {return "/patient" + id;}
    public String getDiseaseDescribe() { return diseaseDescribe; }
    public void setDiseaseDescribe(String diseaseDescribe) { this.diseaseDescribe = diseaseDescribe; }
    public String getFullName() { return name + " " + surname; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }
}
