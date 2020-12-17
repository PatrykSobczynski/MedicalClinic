package com.sobczynski.medical_clinic.controller;

import com.sobczynski.medical_clinic.model.Doctor;
import com.sobczynski.medical_clinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors", doctorService.getDoctorList());
        return "doctors";
    }

    @GetMapping("/addNewDoctor")
    public String newDoctor(Model model) {
        model.addAttribute("dN", doctorService.getDoctorList());
        model.addAttribute("newDoctor", new Doctor());
        return  "addNewDoctor";
    }

    @PostMapping("/doctor/addDoctor")
    public String confirmAddDoctor(@ModelAttribute Doctor d) {
        doctorService.addDoctor(d);
        return "redirect:/doctors";
    }

    @GetMapping("/editDoctorDetails{id}")
    public String editDoctorDetails(Model model, @PathVariable Long id) {
        model.addAttribute("eD", doctorService.findDoctorById(id));
        return "editDoctorDetails";
    }

    @PostMapping("/doctor{id}/updateDetails")
    public String saveDetails(@ModelAttribute Doctor doctor) {
        doctorService.changeDetails(doctor);
        return "redirect:/doctors";
    }

    @PostMapping("/doctor{id}/deleteDoctor")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }

}
