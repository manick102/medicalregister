
# Design Document: MedicalRegister Application

## 1. Overview
The **MedicalRegister** application is a patient management system developed using **Spring Boot** with an XHTML front end. It handles patient registration, CRUD operations, and medical history management.

## 2. Architectural Pattern
- **Layered (N-tier) architecture**
- **Monolithic deployment**, structured for future microservice migration
- **Thymeleaf/XHTML**-based UI
- **RESTful API** endpoints

## 3. Key Functionalities

| Functionality              | Description                                |
|---------------------------|--------------------------------------------|
| Register patient (UI/API) | Create new patient via XHTML or API        |
| View patient list         | Show all registered patients               |
| View patient details      | Retrieve patient by ID with history        |
| Update patient info       | Modify patient data                        |
| Delete patient            | Remove patient by ID                       |
| Add medical history       | Add history entries for a patient          |
| View medical history      | Display all history records per patient    |

## 4. Technologies Used

| Technology       | Purpose                          |
|------------------|----------------------------------|
| Spring Boot       | Backend framework                |
| Spring Data JPA   | ORM and repository layer         |
| Thymeleaf/XHTML   | Server-rendered UI               |
| H2/Postgres/MySQL | Persistence                      |
| Lombok            | Boilerplate reduction            |
| SLF4J             | Logging                          |

## 5. UML Diagram
See attached UML class diagram.

## 6. Suggested Enhancements

| Enhancement                  | Justification                        |
|-----------------------------|--------------------------------------|
| Add validation via `@Valid` | Ensure clean and secure data entry  |
| Implement DTO classes       | Decouple internal entities          |
| Add pagination              | Improve performance on large data   |
| Sequence generator IDs      | Avoid manual ID assignment          |
| Add error handling          | Improve UX                          |
| Introduce microservices     | Scalability                         |
| Add Swagger/OpenAPI         | REST API documentation              |
| Add user authentication     | Restrict access to data             |
