package com.sobczynski.medical_clinic.controller;

import com.sobczynski.medical_clinic.model.Patient;
import com.sobczynski.medical_clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/patient")
    public String patient(Model model, String q) {
        if (q == null) {
            model.addAttribute("patients", patientService.getPatients());
        } else {
            model.addAttribute("patients", patientService.findPatientBySurname(q));
        }
        return "patient";
    }

    @GetMapping("/patient{id}")
    public String patientDetails(Model model, @PathVariable Long id) {
        model.addAttribute("p", patientService.findPatientById(id));
        return "patientDetails";
    }

    @GetMapping("/patient{id}edit")
    public String editDetails(Model model, @PathVariable Long id) {
        model.addAttribute("pE", patientService.findPatientById(id));
        return "editPatientDetails";
    }

    @PostMapping("/patient{id}/updateDetails")
    public String saveDetails(@ModelAttribute Patient p) {
        patientService.changeDetails(p);
        return "redirect:/patient{id}";
    }

    @PostMapping("/patient{id}/deletePatient")
    public String deletePatient(@PathVariable Long id) {
        patientService.delPatient(id);
        return "redirect:/patient";
    }

    @GetMapping("/patientAddNewPatient")
    public String addPatient(Model model) {
        model.addAttribute("pN", patientService.getPatients());
        model.addAttribute("newPatient", new Patient());
        return "addNewPatient";
    }

    @PostMapping("/patient/addPatient")
    public String confirmAddPatient(@ModelAttribute Patient p) {
        patientService.addPatient(p);
        return "redirect:/patient";
    }

    @GetMapping("/disease")
    public String disease(Model model, String q) {
        if(q == null) {
            model.addAttribute("di", patientService.getPatients());
        } else {
            model.addAttribute("di", patientService.findDisease(q));
        }
        return "disease";
    }
}
