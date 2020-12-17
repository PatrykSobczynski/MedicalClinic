package com.sobczynski.medical_clinic.service;

import com.sobczynski.medical_clinic.model.Doctor;
import com.sobczynski.medical_clinic.repository.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    private DoctorDao doctorDao;
    private List<Doctor> doctorList;

    public DoctorServiceImpl() {
    }

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
        doctorList = doctorDao.findAllDoctors();
    }

    @Override
    public List<Doctor> getDoctorList() {
        return doctorDao.findAllDoctors();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void deleteDoctor(Long id) { doctorDao.deleteDoctor(id); }

    @Override
    public Doctor findDoctorById(Long id) { return doctorDao.findDoctorById(id);}

    @Override
    public void changeDetails(Doctor doctor) {
        doctorDao.updateDoctor(doctor);
    }
}
