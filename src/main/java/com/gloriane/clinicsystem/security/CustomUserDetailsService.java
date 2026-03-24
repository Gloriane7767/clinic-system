package com.gloriane.clinicsystem.security;

import com.gloriane.clinicsystem.repository.AdminRepository;
import com.gloriane.clinicsystem.repository.DoctorRepository;
import com.gloriane.clinicsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired private AdminRepository   adminRepository;
    @Autowired private DoctorRepository  doctorRepository;
    @Autowired private PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Check admins first
        var admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return new User(admin.getEmail(), admin.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }

        // Check doctors
        var doctor = doctorRepository.findByEmail(email);
        if (doctor != null) {
            return new User(doctor.getEmail(), doctor.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_DOCTOR")));
        }

        // Check patients
        var patient = patientRepository.findByEmail(email);
        if (patient != null) {
            return new User(patient.getEmail(), patient.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_PATIENT")));
        }

        throw new UsernameNotFoundException("No user found with email: " + email);
    }
}
