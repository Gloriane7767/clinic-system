package com.gloriane.clinicsystem.controller;

import com.gloriane.clinicsystem.model.Doctor;
import com.gloriane.clinicsystem.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Admin: view all doctors + add-doctor form
    @GetMapping("/doctors")
    public String doctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("newDoctor", new Doctor());
        return "doctors";
    }

    // Admin: submit the add-doctor form
    @PostMapping("/doctors")
    public String addDoctor(@Valid @ModelAttribute("newDoctor") Doctor doctor) {
        doctorService.save(doctor);
        return "redirect:/doctors";
    }

    // Public: patient searches doctors by name — no login needed
    @GetMapping("/search-doctors")
    public String searchDoctors(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isBlank()) {
            model.addAttribute("doctors", doctorService.searchByName(name));
            model.addAttribute("query", name);
        }
        return "search-doctors";
    }
}
