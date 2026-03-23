-- Sample admins
INSERT INTO admins (name, email, password) VALUES
                                               ('Super Admin',  'admin@clinic.com',       'admin123'),
                                               ('Jane Manager', 'jane.manager@clinic.com', 'manager123');

-- Sample doctors
INSERT INTO doctors (name, email, specialty, phone) VALUES
                                                        ('Dr. John Smith',   'john.smith@clinic.com',   'Cardiology',    '555-1001'),
                                                        ('Dr. Sarah Lee',    'sarah.lee@clinic.com',     'Dermatology',   '555-1002'),
                                                        ('Dr. Mike Brown',   'mike.brown@clinic.com',    'Pediatrics',    '555-1003'),
                                                        ('Dr. Anna White',   'anna.white@clinic.com',    'Neurology',     '555-1004');

-- Sample patients
INSERT INTO patients (name, email, phone, dob) VALUES
                                                   ('Alice Johnson', 'alice@email.com',   '555-2001', '1990-04-15'),
                                                   ('Bob Williams',  'bob@email.com',     '555-2002', '1985-08-22'),
                                                   ('Carol Davis',   'carol@email.com',   '555-2003', '2000-01-10'),
                                                   ('David Martinez','david@email.com',   '555-2004', '1978-11-30');

-- Sample appointments
INSERT INTO appointments (patient_id, doctor_id, appt_date, status) VALUES
                                                                        (1, 1, '2024-06-01 09:00:00', 'SCHEDULED'),
                                                                        (2, 2, '2024-06-01 10:00:00', 'SCHEDULED'),
                                                                        (3, 3, '2024-06-02 11:00:00', 'COMPLETED'),
                                                                        (4, 4, '2024-06-03 14:00:00', 'CANCELLED'),
                                                                        (1, 3, '2024-06-04 09:30:00', 'SCHEDULED');