# Smart Clinic Management System

A web-based clinic management system built with Java Spring Boot,
MySQL, MongoDB, Docker, and GitHub Actions.

## Features
- Admin dashboard with patient, doctor, and appointment counts
- Patient and doctor management
- Appointment booking and tracking
- Secure login with JWT authentication
- REST API for all core resources
- Dockerized for easy deployment
- CI pipeline with GitHub Actions

## Technology Stack
| Layer      | Technology              |
|------------|-------------------------|
| Frontend   | HTML, CSS, JavaScript, Thymeleaf |
| Backend    | Java 17, Spring Boot 3  |
| Database   | MySQL, MongoDB          |
| Auth       | JWT (JSON Web Tokens)   |
| Container  | Docker + Docker Compose |
| CI/CD      | GitHub Actions          |

## How to run locally

### Option 1 — Run with Docker (recommended)
Make sure Docker Desktop is running, then:
```bash
docker-compose up --build
```
Open your browser at: http://localhost:8080

### Option 2 — Run without Docker
1. Make sure MySQL is running and `clinic_db` database exists
2. Update `src/main/resources/application.properties` with your MySQL password
3. Run the app from IntelliJ or with:
```bash
./mvnw spring-boot:run
```
Open your browser at: http://localhost:8080

## Login credentials (for testing)
- Email: admin@clinic.com
- Password: admin123

## REST API Endpoints
| Method | URL                    | Description            |
|--------|------------------------|------------------------|
| GET    | /api/patients          | Get all patients       |
| GET    | /api/patients/{id}     | Get patient by ID      |
| POST   | /api/patients          | Create new patient     |
| PUT    | /api/patients/{id}     | Update patient         |
| DELETE | /api/patients/{id}     | Delete patient         |
| GET    | /api/doctors           | Get all doctors        |
| GET    | /api/doctors/{id}      | Get doctor by ID       |
| POST   | /api/doctors           | Create new doctor      |
| GET    | /api/appointments      | Get all appointments   |
| POST   | /api/appointments      | Create appointment     |
| PUT    | /api/appointments/{id} | Update appointment     |

## Project Structure
```
clinic-system/
├── src/main/java/com/clinic/clinicsystem/
│   ├── api/          REST controllers (JSON responses)
│   ├── controller/   MVC controllers (HTML page responses)
│   ├── model/        JPA entity classes
│   ├── repository/   Spring Data JPA interfaces
│   └── security/     JWT utility and Spring Security config
├── src/main/resources/
│   ├── db/           SQL scripts and stored procedures
│   └── templates/    Thymeleaf HTML pages
├── Dockerfile
├── docker-compose.yml
└── .github/workflows/ci.yml
```

## GitHub Repository
https://github.com/Gloriane7767/clinic-system