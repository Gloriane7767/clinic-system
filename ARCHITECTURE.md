# Smart Clinic Management System — Architecture Design Document

## 1. Project overview
A web-based clinic management system that allows admins to manage doctors,
patients, and appointments. Built with Java Spring Boot (backend),
HTML/CSS/JS (frontend), MySQL and MongoDB (databases), and Docker (deployment).

## 2. System architecture
The system follows a 3-layer architecture:

- Frontend layer: HTML/CSS/JS pages served to the browser
- Backend layer: Java Spring Boot REST API (handles business logic)
- Database layer: MySQL for structured data, MongoDB for appointments

## 3. Microservices
| Service             | Responsibility                        |
|---------------------|---------------------------------------|
| Patient Service     | Register, view, update patients       |
| Doctor Service      | Manage doctor profiles                |
| Appointment Service | Book, cancel, list appointments       |
| Auth Service        | Login, issue and validate JWT tokens  |

## 4. Technology stack
| Layer      | Technology              |
|------------|-------------------------|
| Frontend   | HTML, CSS, JavaScript   |
| Backend    | Java 17, Spring Boot 3  |
| Database   | MySQL, MongoDB          |
| Auth       | JWT (JSON Web Tokens)   |
| Container  | Docker                  |
| CI/CD      | GitHub Actions          |

## 5. How a request flows through the system
1. User fills in the login form (Frontend)
2. Browser sends a POST request to /api/auth/login (Backend)
3. Auth Service checks credentials in MySQL
4. If valid, a JWT token is returned to the browser
5. Browser stores the token and uses it for all future requests

## 6. GitHub repository
Link: https://github.com/Gloriane7767/clinic-system