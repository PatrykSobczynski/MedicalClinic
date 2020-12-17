package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Doctor;

import java.util.List;

public interface DoctorDao {
    void addDoctor(Doctor doctor);

    void deleteDoctor(Long id);

    List<Doctor> findAllDoctors();

    void updateDoctor(Doctor doctor);

    Doctor findDoctorById(Long id);
}
