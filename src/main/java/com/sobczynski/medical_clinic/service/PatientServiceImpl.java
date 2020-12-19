package com.sobczynski.medical_clinic.service;

import com.sobczynski.medical_clinic.model.Patient;
import com.sobczynski.medical_clinic.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;
    private List<Patient> patientList;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
        patientList = patientDao.findAllPatients();
    }

    public PatientServiceImpl() {
    }

    @Override
    public List<Patient> getPatients() {
        return patientDao.findAllPatients();
    }


    @Override
    public List<Patient> findPatientBySurname(String name) {
        return patientList.stream().filter(patient ->
                patient.getSurname().equalsIgnoreCase(name)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> findDisease(String disease) {
        return patientList.stream().filter(patient ->
                patient.getDisease().equalsIgnoreCase(disease)).collect(Collectors.toList());
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientDao.findPatientBySQL(id);
    }

    @Override
    public void changeDetails(Patient patient) {
        patientDao.updatePatient(patient);
    }

    @Override
    public void delPatient(Long id) {
        patientDao.deletePatient(id);
    }

    @Override
    public void addPatient(Patient patient) {
        patientDao.addPatient(patient);
    }

//    @Override
//    public void addPatients() {
//        patientList = new ArrayList<>();
//
//        patientList.add(new Patient("Jan", "Kowalski", 25, "Gorączka", "-"));
//        patientList.add(new Patient("Patryk", "Kowal", 52,"Ból głowy","-"));
//        patientList.add(new Patient("Maciek", "Dupa", 14,"Duszności", "-"));
//        patientList.add(new Patient("Dawid", "Baran", 32,"Zawroty głowy", "-"));
//        patientList.add(new Patient("Adam", "Analityk", 15,"Wymioty", "-"));
//        patientList.add(new Patient("Marcin", "Giemza", 26,"Złamanie otwarte", "-"));
//        patientList.add(new Patient("Rafał", "Budczyński", 51,"Duszności", "-"));
//        patientList.add(new Patient("Marta", "Walczak", 33,"Ból brzucha", "-"));
//        patientList.add(new Patient("Bogdan", "Boner", 28,"Postrzelenie", "-"));
//        patientList.add(new Patient("Dominika", "Swiatły", 19,"Gorączka", "-"));
//        patientList.add(new Patient("Maciej", "Borowieski", 6,"Złamanie", "-"));
//        patientList.add(new Patient("Piotrek", "Borowieski", 9,"Skręcenie", "-"));
//        patientList.add(new Patient("Wojtek", "Borowieski", 12,"Udar", "-"));

//    }
}
