package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors VALUES(null, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, doctor.getName(), doctor.getSurname(),
                doctor.getSpecialization(), doctor.getNumberOfPhone());
    }

    @Override
    public void deleteDoctor(Long id){
        String sql = "DELETE FROM doctors WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Doctor> findAllDoctors() {
        String sql = "SELECT * FROM doctors";
        List<Doctor> doctorList = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Doctor(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("specialization"),
                        rs.getInt("number_of_phone"))
                );
                return doctorList;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        if(doctor.getName() != null) {
            String sql = "UPDATE doctors d SET d.NAME = '" + doctor.getName() + "' WHERE d.ID = ?";
            jdbcTemplate.update(sql, doctor.getId());
        }
        if(doctor.getSurname() != null) {
            String sql = "UPDATE doctors d SET d.SURNAME = '" + doctor.getSurname() + "' WHERE d.ID = ?";
            jdbcTemplate.update(sql, doctor.getId());
        }
        if(doctor.getSpecialization() != null) {
            String sql = "UPDATE doctors d SET d.SPECIALIZATION = '" + doctor.getSpecialization() + "' WHERE d.ID = ?";
            jdbcTemplate.update(sql, doctor.getId());
        }
        if(doctor.getNumberOfPhone() != 0) {
            String sql = "UPDATE doctors d SET d.NUMBER_OF_PHONE = '" + doctor.getNumberOfPhone() + "' WHERE d.ID = ?";
            jdbcTemplate.update(sql, doctor.getId());
        }
    }

    @Override
    public Doctor findDoctorById(Long id) {

        String sql = "SELECT * FROM doctors d WHERE d.ID = " + id;
        Doctor doctor = jdbcTemplate.queryForObject(sql, (resultSet, rowNum) ->
                new Doctor(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("specialization"),
                        resultSet.getInt("number_of_phone"))
                );
        return doctor;
    }
}
