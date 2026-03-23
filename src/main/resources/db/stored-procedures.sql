-- Procedure 1: Get all appointments for a specific doctor
DELIMITER $$

CREATE PROCEDURE GetAppointmentsByDoctor(IN doctorId BIGINT)
BEGIN
SELECT
    a.id,
    p.name  AS patient_name,
    a.appt_date,
    a.status
FROM appointments a
         JOIN patients p ON a.patient_id = p.id
WHERE a.doctor_id = doctorId
ORDER BY a.appt_date;
END $$

DELIMITER ;

-- Procedure 2: Get all appointments for a specific patient
DELIMITER $$

CREATE PROCEDURE GetAppointmentsByPatient(IN patientId BIGINT)
BEGIN
SELECT
    a.id,
    d.name  AS doctor_name,
    d.specialty,
    a.appt_date,
    a.status
FROM appointments a
         JOIN doctors d ON a.doctor_id = d.id
WHERE a.patient_id = patientId
ORDER BY a.appt_date;
END $$

DELIMITER ;

-- Procedure 3: Count appointments by status
DELIMITER $$

CREATE PROCEDURE GetAppointmentSummary()
BEGIN
SELECT
    status,
    COUNT(*) AS total
FROM appointments
GROUP BY status;
END $$

DELIMITER ;