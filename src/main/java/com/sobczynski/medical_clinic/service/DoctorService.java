package com.sobczynski.medical_clinic.service;

import com.sobczynski.medical_clinic.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getDoctorList();
    void addDoctor(Doctor doctor);

    void deleteDoctor(Long id);

    Doctor findDoctorById(Long id);

    void changeDetails(Doctor doctor);
}
