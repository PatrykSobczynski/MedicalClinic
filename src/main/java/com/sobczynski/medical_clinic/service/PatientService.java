package com.sobczynski.medical_clinic.service;

import com.sobczynski.medical_clinic.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getPatients();
    List<Patient> findPatientBySurname(String name);
    List<Patient> findDisease(String disease);
    Patient findPatientById(Long id);

    void changeDetails(Patient patient);

    void delPatient(Long id);

    void addPatient(Patient patient);
}
