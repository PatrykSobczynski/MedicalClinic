package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPatient(Patient patient) {
        String sql = "INSERT INTO clinic VALUES(null, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, patient.getName(), patient.getSurname(), patient.getAge(),
                patient.getDisease(), patient.getDiseaseDescribe(), patient.getBedNumber());
    }

    @Override
    public List<Patient> findAllPatients() {
        String sql = "SELECT * FROM clinic";
        List<Patient> patientList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Patient(rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("age"),
                            rs.getString("disease"),
                            rs.getString("disease_describe"),
                            rs.getInt("BED_NUMBER"))
                );
                return patientList;
    }

    @Override
    public void updatePatient(Patient patient) {
        if(patient.getName() != null) {
            String sql = "UPDATE clinic p SET p.NAME = '" + patient.getName() + "' WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
        if(patient.getSurname() != null) {
            String sql = "UPDATE clinic p SET p.SURNAME = '" + patient.getSurname() + "' WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
        if(patient.getDisease() != null) {
            String sql = "UPDATE clinic p SET p.AGE = '" + patient.getAge() + "' WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
        if(patient.getDisease() != null) {
            String sql = "UPDATE clinic p SET p.DISEASE = '" + patient.getDisease() + "' WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
        if(patient.getDiseaseDescribe() != null) {
            String sql = "UPDATE clinic p SET p.DISEASE_DESCRIBE = '" + patient.getDiseaseDescribe() + "' WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
        if(patient.getBedNumber() != 0) {
            String sql = "UPDATE clinic p SET p.BED_NUMBER ='" + patient.getBedNumber() + "'WHERE p.ID = ?";
            jdbcTemplate.update(sql, patient.getId());
        }
    }

    @Override
    public void deletePatient(Long id) {
        String sql = "DELETE FROM clinic WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Patient findPatientBySQL(Long id) {
        String sql = "SELECT * FROM clinic p WHERE p.ID = " + id;

        Patient patient = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Patient(rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getInt("age"),
                            rs.getString("disease"),
                            rs.getString("disease_describe"),
                            rs.getInt("bed_number"))
                );
        return patient;
    }

/**
 *          POTRZEBNE TYLKO DO DODANIA W BAZIE DANYCH
 */

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        List<Patient> patientList = new ArrayList<>();
//
//        patientList.add(new Patient("Koń", "Rafał", 45, "Ból oczu", "-", 10));
//        patientList.add(new Patient("Marta", "Gniazdo", 84,"Zawroty głowy","-", 11));
//        patientList.add(new Patient("Dominika", "Nowak", 15,"Brak objawów", "-", 12));
//        patientList.add(new Patient("Marcin", "Opara", 16,"Złamanie", "-", 13));
//        patientList.add(new Patient("Adam", "Obserwator", 25,"Wymioty", "-", 14));
//        patientList.add(new Patient("Marcin", "-", 26,"Złamanie otwarte", "-", 15));
//        patientList.add(new Patient("Maciek", "Mateusz", 35,"Duszności", "-", 16));
//
//        for(Patient patient : patientList) {
//            String sql = "INSERT INTO clinic VALUES (null, ?, ?, ?, ?, ?,?)";
//            jdbcTemplate.update(sql, patient.getName(), patient.getSurname(), patient.getAge(), patient.getDisease(), patient.getDiseaseDescribe(), patient.getBedNumber());
//        }
//    }
}
