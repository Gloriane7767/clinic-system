package com.gloriane.clinicsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "appointment_notes")  // This = a MongoDB collection (like a table)
public class AppointmentNote {

    @Id                          // MongoDB uses String IDs, not Long like MySQL
    private String id;

    private Long appointmentId;  // Links this note to a MySQL appointment by ID

    private String authorName;   // Who wrote the note

    private String noteText;     // The actual note content

    private LocalDateTime createdAt = LocalDateTime.now();  // Auto-set to now
}
