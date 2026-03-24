package com.gloriane.clinicsystem.security;

import com.gloriane.clinicsystem.repository.DoctorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication auth) throws IOException {

        String role = auth.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_ADMIN" -> response.sendRedirect("/dashboard");
            case "ROLE_DOCTOR" -> {
                // Find the doctor's ID so we can link to their appointments
                var doctor = doctorRepository.findByEmail(auth.getName());
                response.sendRedirect("/doctors/" + doctor.getId() + "/appointments");
            }
            case "ROLE_PATIENT" -> response.sendRedirect("/search-doctors");
            default -> response.sendRedirect("/");
        }
    }
}
