package com.gloriane.clinicsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne                          // Many appointments can belong to one patient
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne                          // Many appointments can belong to one doctor
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @NotNull(message = "Appointment date is required")
    @Column(nullable = false)
    private LocalDateTime apptDate;

    @Column(nullable = false)
    private String status = "SCHEDULED"; // Default value
}