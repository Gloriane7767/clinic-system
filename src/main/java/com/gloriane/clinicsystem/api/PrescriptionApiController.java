package com.gloriane.clinicsystem.api;

import com.gloriane.clinicsystem.model.Prescription;
import com.gloriane.clinicsystem.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionApiController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping
    public List<Prescription> getAll() {
        return prescriptionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        return prescriptionService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/appointment/{appointmentId}")
    public List<Prescription> getByAppointment(@PathVariable Long appointmentId) {
        return prescriptionService.getByAppointmentId(appointmentId);
    }

    @PostMapping
    public Prescription create(@Valid @RequestBody Prescription prescription) {
        return prescriptionService.save(prescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!prescriptionService.exists(id)) return ResponseEntity.notFound().build();
        prescriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
