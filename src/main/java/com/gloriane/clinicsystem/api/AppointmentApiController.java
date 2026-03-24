package com.gloriane.clinicsystem.api;

import com.gloriane.clinicsystem.model.Appointment;
import com.gloriane.clinicsystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentApiController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appointment createAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateStatus(@PathVariable Long id,
                                                    @RequestBody Appointment updated) {
        return appointmentRepository.findById(id)
                .map(existing -> {
                    existing.setStatus(updated.getStatus());
                    return ResponseEntity.ok(appointmentRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

