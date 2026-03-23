package com.gloriane.clinicsystem.repository;

// DoctorRepository.java

import com.gloriane.clinicsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
