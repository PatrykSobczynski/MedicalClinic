package com.sobczynski.medical_clinic.repository;

import com.sobczynski.medical_clinic.model.Visit;

import java.util.List;

public interface VisitDao {
    List<Visit> findAllVisit();

    Visit findVisitById(Long id);

    void addVisit(Visit visit);

    void updateVisit(Visit visit);

    void deleteVisit(Long id);
}
