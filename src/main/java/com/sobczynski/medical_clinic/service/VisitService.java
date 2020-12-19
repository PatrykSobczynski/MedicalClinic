package com.sobczynski.medical_clinic.service;


import com.sobczynski.medical_clinic.model.Visit;

import java.util.List;

public interface VisitService {

    List<Visit> getVisit();

    void addVisit(Visit visit);

    void updateVisit(Visit visit);

    void deleteVisit(Long id);

    Visit findVisitById(Long id);
}
