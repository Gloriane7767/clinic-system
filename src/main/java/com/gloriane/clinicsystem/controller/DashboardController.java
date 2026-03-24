package com.gloriane.clinicsystem.controller;

import com.gloriane.clinicsystem.repository.*;
import com.gloriane.clinicsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {

    @Autowired private PatientRepository     patientRepository;
    @Autowired private DoctorRepository      doctorRepository;
    @Autowired private AppointmentRepository appointmentRepository;
    @Autowired private AppointmentService    appointmentService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("patientCount",     patientRepository.count());
        model.addAttribute("doctorCount",      doctorRepository.count());
        model.addAttribute("appointmentCount", appointmentRepository.count());
        return "dashboard";
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

    // Doctor views only their own appointments: /doctors/3/appointments
    @GetMapping("/doctors/{doctorId}/appointments")
    public String doctorAppointments(@PathVariable Long doctorId, Model model) {
        model.addAttribute("appointments", appointmentService.getByDoctorId(doctorId));
        model.addAttribute("doctorId", doctorId);
        return "appointments";
    }

    @GetMapping("/appointments/{appointmentId}/notes")
    public String appointmentNotes(@PathVariable Long appointmentId, Model model) {
        model.addAttribute("appointmentId", appointmentId);
        return "notes";
    }
}
