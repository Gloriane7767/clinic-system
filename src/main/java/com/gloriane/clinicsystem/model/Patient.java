package com.gloriane.clinicsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data                          // Lombok: auto-generates getters, setters, toString
@Entity                        // Tells JPA: this class = a database table
@Table(name = "patients")      // Which table it maps to
public class Patient {

    @Id                                         // This field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @NotBlank(message = "Name is required")     // Validation: cannot be empty
    @Column(nullable = false)
    private String name;

    @Email(message = "Email must be valid")     // Validation: must look like an email
    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private LocalDate dob;                      // Date of birth
}
