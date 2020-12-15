package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Patient;

import java.util.List;

// CRUD
public interface PatientDao {
    void addPatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(Long id);

    List<Patient> findAllPatients();

    Patient findPatientBySQL(Long id);




}
