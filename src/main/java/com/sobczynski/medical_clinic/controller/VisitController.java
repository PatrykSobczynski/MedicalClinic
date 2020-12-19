package com.sobczynski.medical_clinic.controller;

import com.sobczynski.medical_clinic.model.Doctor;
import com.sobczynski.medical_clinic.model.Patient;
import com.sobczynski.medical_clinic.model.Visit;
import com.sobczynski.medical_clinic.service.DoctorService;
import com.sobczynski.medical_clinic.service.PatientService;
import com.sobczynski.medical_clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class VisitController {
    private PatientService patientService;
    private DoctorService doctorService;
    private VisitService visitService;

    @Autowired
    public VisitController(PatientService patientService, DoctorService doctorService, VisitService visitService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.visitService = visitService;
    }

    @GetMapping("/visit")
    public String visit(Model model) {
        List<Patient> patientList = patientService.getPatients();
        List<Doctor> doctorList = doctorService.getDoctorList();
        List<Visit> visitList = visitService.getVisit();
        model.addAttribute("visits", visitList);
        model.addAttribute("patients", patientList);
        model.addAttribute("doctors", doctorList);
        return "visit";
    }

    @GetMapping("/addNewVisit")
    public String newVisit(Model model) {
        Visit visit = new Visit();
        List<Patient> patientList = patientService.getPatients();
        List<Doctor> doctorList = doctorService.getDoctorList();
        model.addAttribute("nV", visitService.getVisit());
        model.addAttribute("newVisit", visit);
        model.addAttribute("patients", patientList);
        model.addAttribute("doctors", doctorList);
        return "addNewVisit";
    }

    @PostMapping("/visit/addVisit")
    public String confirmAddVisit(@ModelAttribute Visit newVisit) {
        visitService.addVisit(newVisit);
        return "redirect:/visit";
    }

    @PostMapping("/visit{id}/deleteVisit")
    public String deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
        return "redirect:/visit";
    }
}