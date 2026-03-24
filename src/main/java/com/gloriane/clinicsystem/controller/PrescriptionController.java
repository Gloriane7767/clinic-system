package com.gloriane.clinicsystem.controller;

import com.gloriane.clinicsystem.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // /prescriptions — shows all prescriptions
    @GetMapping("/prescriptions")
    public String prescriptions(Model model) {
        model.addAttribute("prescriptions", prescriptionService.getAll());
        return "prescriptions";  // loads prescriptions.html
    }

    // /appointments/1/prescriptions — shows prescriptions for one appointment
    @GetMapping("/appointments/{appointmentId}/prescriptions")
    public String prescriptionsByAppointment(@PathVariable Long appointmentId, Model model) {
        model.addAttribute("prescriptions", prescriptionService.getByAppointmentId(appointmentId));
        model.addAttribute("appointmentId", appointmentId);
        return "prescriptions";
    }
}
