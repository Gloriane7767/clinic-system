package com.gloriane.clinicsystem.api;

import com.gloriane.clinicsystem.model.Patient;
import com.gloriane.clinicsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController           // Like @Controller but returns JSON, not HTML pages
@RequestMapping("/api/patients")  // All URLs in this class start with /api/patients
public class PatientApiController {

    @Autowired
    private PatientRepository patientRepository;

    // GET /api/patients — returns all patients as JSON
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // GET /api/patients/1 — returns one patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(ResponseEntity::ok)                        // Found: return 200 OK + patient
                .orElse(ResponseEntity.notFound().build());     // Not found: return 404
    }

    // POST /api/patients — creates a new patient
    @PostMapping
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        // @RequestBody reads the JSON from the request and converts it to a Patient object
        // @Valid runs your validation annotations (@NotBlank, @Email etc.)
        return patientRepository.save(patient);
    }

    // PUT /api/patients/1 — updates an existing patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,
                                                 @Valid @RequestBody Patient updated) {
        return patientRepository.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setEmail(updated.getEmail());
                    existing.setPhone(updated.getPhone());
                    existing.setDob(updated.getDob());
                    return ResponseEntity.ok(patientRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/patients/1 — deletes a patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (!patientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        patientRepository.deleteById(id);
        return ResponseEntity.noContent().build();  // 204 No Content = success, nothing to return
    }
}