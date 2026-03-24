package com.gloriane.clinicsystem.api;

import com.gloriane.clinicsystem.model.AppointmentNote;
import com.gloriane.clinicsystem.repository.AppointmentNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments/{appointmentId}/notes")
public class AppointmentNoteApiController {

    @Autowired
    private AppointmentNoteRepository noteRepository;

    // GET /api/appointments/1/notes — get all notes for appointment 1
    @GetMapping
    public List<AppointmentNote> getNotes(@PathVariable Long appointmentId) {
        return noteRepository.findByAppointmentId(appointmentId);
    }

    // POST /api/appointments/1/notes — add a note to appointment 1
    @PostMapping
    public AppointmentNote addNote(@PathVariable Long appointmentId,
                                   @RequestBody AppointmentNote note) {
        note.setAppointmentId(appointmentId);  // Link the note to this appointment
        return noteRepository.save(note);
    }

    // DELETE /api/appointments/1/notes/abc123 — delete one specific note
    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long appointmentId,
                                           @PathVariable String noteId) {
        if (!noteRepository.existsById(noteId)) {
            return ResponseEntity.notFound().build();
        }
        noteRepository.deleteById(noteId);
        return ResponseEntity.noContent().build();
    }
}