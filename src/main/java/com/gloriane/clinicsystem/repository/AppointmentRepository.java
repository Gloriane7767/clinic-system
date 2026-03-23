package com.gloriane.clinicsystem.repository;

// AppointmentRepository.java
import com.gloriane.clinicsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}