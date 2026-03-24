package com.gloriane.clinicsystem.controller;


import com.gloriane.clinicsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller  // Tells Spring: this class handles web page requests
public class DashboardController {
    @Autowired
    private PatientRepository     patientRepository;
    @Autowired
    private DoctorRepository      doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/dashboard")  // When browser visits /dashboard, run this method
    public String dashboard(Model model) {
        // Count records and pass them to the HTML page
        model.addAttribute("patientCount",     patientRepository.count());
        model.addAttribute("doctorCount",      doctorRepository.count());
        model.addAttribute("appointmentCount", appointmentRepository.count());
        return "dashboard";  // Loads dashboard.html from templates/
    }

    @GetMapping("/patients")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patients";
    }

    @GetMapping("/appointments")
    public String appointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments";
    }

    @GetMapping("/appointments/{appointmentId}/notes")
    public String appointmentNotes(@PathVariable Long appointmentId, Model model) {
        model.addAttribute("appointmentId", appointmentId);
        return "notes";  // loads notes.html
    }
}