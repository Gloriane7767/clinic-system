package com.gloriane.clinicsystem.repository;

// AdminRepository.java
import com.gloriane.clinicsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}