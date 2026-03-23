package com.gloriane.clinicsystem.repository;

// PatientRepository.java
import com.gloriane.clinicsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // JpaRepository gives you findAll(), findById(), save(), delete() for free
    // You can also add custom methods like:
    Patient findByEmail(String email);
}
