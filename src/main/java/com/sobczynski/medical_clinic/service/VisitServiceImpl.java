package com.sobczynski.medical_clinic.service;

import com.sobczynski.medical_clinic.model.Doctor;
import com.sobczynski.medical_clinic.model.Patient;
import com.sobczynski.medical_clinic.model.Visit;
import com.sobczynski.medical_clinic.repository.DoctorDao;
import com.sobczynski.medical_clinic.repository.PatientDao;
import com.sobczynski.medical_clinic.repository.VisitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private PatientDao patientDao;
    private List<Patient> patientList;
    private DoctorDao doctorDao;
    private List<Doctor> doctorList;
    private VisitDao visitDao;
    private List<Visit> visitList;

    @Autowired
    public VisitServiceImpl(PatientDao patientDao, DoctorDao doctorDao, VisitDao visitDao) {
        this.patientDao = patientDao;
        patientList = patientDao.findAllPatients();
        this.doctorDao = doctorDao;
        doctorList = doctorDao.findAllDoctors();
        this.visitDao = visitDao;
        visitList = visitDao.findAllVisit();
    }

    @Override
    public List<Visit> getVisit() {
        return visitDao.findAllVisit();
    }

    @Override
    public void addVisit(Visit visit) {
        visitDao.addVisit(visit);
    }

    @Override
    public void updateVisit(Visit visit) {
        visitDao.updateVisit(visit);
    }

    @Override
    public void deleteVisit(Long id) {
        visitDao.deleteVisit(id);
    }

    @Override
    public Visit findVisitById(Long id) {
        return visitDao.findVisitById(id);
    }

}
