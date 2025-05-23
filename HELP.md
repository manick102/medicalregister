🏥 Medical Register API - Spring Boot

This application provides REST APIs to manage patient data with secure access using mocked LDAP/Auth0 (in-memory)
authentication.

📁 Project Structure
model.Patient — JPA Entity for patients table

model.MedicalHistory — JPA Entity for medical history table

repository.PatientRepository — Spring Data JPA interface

service.PatientService — Business logic layer

controller.PatientController — REST API endpoints

config.SecurityConfig — Basic Auth-based security for /api/**

test.PatientServiceTest — JUnit test cases for service logic

🔐 Security
Configured using Spring Security with mocked user:

java
Copy
Edit
@Bean
public UserDetailsService userDetailsService() {
return new InMemoryUserDetailsManager(
User.withUsername("ldapuser")
.password("{noop}password")
.roles("USER")
.build()
);
}
🔐 Basic Auth

🔒 Secured endpoints under /api/**

🛡️ CSRF protection not disabled — state-changing requests (POST, PUT, DELETE) may need CSRF tokens unless explicitly
disabled.

✅ UI
URL: http://localhost:8080/patientslist

✅ API Endpoints
Base URL: http://localhost:8080/api/patients

Method Endpoint Description
GET /api/patients Get all patients
GET /api/patients/{id} Get a patient by ID
POST /api/patients Create a new patient
PUT /api/patients/{id} Update an existing one
DELETE /api/patients/{id} Delete a patient

Request/Response JSON Format:

json
Copy
Edit
{
"id": 1,
"name": "John Doe",
"age": 35,
"medicalHistory": [{"reason": "Diabetes"}]
}
🧪 Authentication (Postman)
Use Basic Auth:

Username: manick

Password: password

🔄 Add Authorization headers under Basic Auth tab in Postman

🧪 Unit Testing
Tests written with JUnit + Mockito for PatientService.

Covers:

getAllPatients()

getPatientById()

savePatient()

deletePatient()

Run with:

bash
Copy
Edit
./mvnw test
▶️ Run the App
bash
Copy
Edit
./mvnw spring-boot:run
Access at: http://localhost:8080/api/patients