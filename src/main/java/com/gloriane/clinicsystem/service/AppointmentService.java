package com.gloriane.clinicsystem.service;

import com.gloriane.clinicsystem.model.Appointment;
import com.gloriane.clinicsystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public boolean exists(Long id) {
        return appointmentRepository.existsById(id);
    }

    public Appointment updateStatus(Long id, String status) {
        return appointmentRepository.findById(id).map(a -> {
            a.setStatus(status);
            return appointmentRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Appointment not found: " + id));
    }
}
