package com.gloriane.clinicsystem.repository;

import com.gloriane.clinicsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByNameContainingIgnoreCase(String name);
    Doctor findByEmail(String email);
}
