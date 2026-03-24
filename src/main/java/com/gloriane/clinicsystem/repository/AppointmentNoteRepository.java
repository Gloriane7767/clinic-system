package com.gloriane.clinicsystem.repository;

import com.gloriane.clinicsystem.model.AppointmentNote;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// MongoRepository works exactly like JpaRepository — same methods, different database
public interface AppointmentNoteRepository extends MongoRepository<AppointmentNote, String> {

    // Spring generates this query automatically from the method name:
    // "Find all notes where appointmentId equals this value"
    List<AppointmentNote> findByAppointmentId(Long appointmentId);

    // Delete all notes for a given appointment
    void deleteByAppointmentId(Long appointmentId);
}