package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Doctor;
import com.sobczynski.medical_clinic.model.Patient;
import com.sobczynski.medical_clinic.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VisitDaoImpl implements VisitDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VisitDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Visit> findAllVisit() {
        String sql = "SELECT v.*, c.SURNAME AS P_SURNAME, d.SURNAME AS D_SURNAME FROM clinic.visit v JOIN clinic.CLINIC c ON c.ID = v.PATIENT_ID JOIN clinic.doctors d ON d.ID = v.DOCTOR_ID";
        List<Visit> visitList = jdbcTemplate.query(sql,
                (new RowMapper<Visit>() {
                    @Override
                    public Visit mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Visit visit = new Visit();
                        visit.setId(rs.getLong("id"));
                        visit.setDate(rs.getDate("date_visit").toString());
                        visit.setPatient(new Patient(rs.getLong("patient_id"), rs.getString("P_SURNAME")));
                        visit.setDoctor(new Doctor(rs.getLong("doctor_id"), rs.getString("D_SURNAME")));

                        return visit;
                    }
                })
            );

        return visitList;
    }

    @Override
    public Visit findVisitById(Long id) {
        String sql = "SELECT v.*, c.SURNAME AS P_SURNAME, d.SURNAME AS D_SURNAME FROM clinic.visit v\n" +
                "JOIN clinic.CLINIC c ON c.ID = v.PATIENT_ID\n" +
                "JOIN clinic.doctors d ON d.ID = v.DOCTOR_ID WHERE v.ID = " + id;
        Visit visit = jdbcTemplate.queryForObject(sql,
                (new RowMapper<Visit>() {
                    @Override
                    public Visit mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Visit visit = new Visit();
                        visit.setId(rs.getLong("id"));
                        visit.setDate(rs.getDate("date_visit").toString());
                        visit.setPatient(new Patient(rs.getLong("patient_id"), rs.getString("P_SURNAME")));
                        visit.setPatient(new Patient(rs.getLong("patient_id"), rs.getString("P_SURNAME")));

                        return visit;
                    }
                })
            );
        return visit;
    }

    @Override
    public void addVisit(Visit visit) {
        String sql = "INSERT INTO visit VALUES(null, ?, ?, ?)";
        jdbcTemplate.update(sql, visit.getDate(), visit.getPatient().getId(), visit.getDoctor().getId());
    }

    @Override
    public void updateVisit(Visit visit) {
        if(visit.getDate() != null) {
            String sql = "UPDATE visit v SET v.DATE_VISIT = '" + visit.getDate() + "' WHERE v.ID = ?";
            jdbcTemplate.update(sql, visit.getDate());
        }
        if(visit.getPatient().getId() != null) {
            String sql = "UPDATE visit v SET v.PATIENT_ID = '" + visit.getPatient().getId() + "'WHERE v.ID = ?";
            jdbcTemplate.update(sql, visit.getPatient().getId());
        }
        if(visit.getDoctor().getId() != null) {
            String sql = "UPDATE visit v SET v.DOCTOR_ID = '" + visit.getDoctor().getId() + "'WHERE v.ID = ?";
            jdbcTemplate.update(sql, visit.getDoctor().getId());
        }
    }

    @Override
    public void deleteVisit(Long id) {
        String sql = "DELETE FROM visit WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}
