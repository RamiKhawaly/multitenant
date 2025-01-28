# Multitenant Implementation in Spring Boot

This repository demonstrates how to implement **row-level multitenancy** in a Spring Boot application. Each object in the application contains a `tenantId` field to segregate data by tenants. An advanced implementation combining **JWT (JSON Web Token)** authentication with multitenancy is available in the `multitenancy-JWT-Combination` branch.

---

## Table of Contents

- [Overview](#overview)
- [Repository Structure](#repository-structure)
- [Technologies Used](#technologies-used)

---

## Overview

Multitenancy ensures that multiple tenants (e.g., organizations or users) can share the same application instance while maintaining strict data isolation. This repository provides:
1. A basic implementation of **row-level multitenancy**, where queries filter data by the `tenantId` field.
2. An advanced implementation integrating **JWT authentication**, where the `tenantId` is embedded in the JWT and used to scope all operations securely.

---

## Repository Structure

### Branches

- **`main`**: Demonstrates the basic implementation of row-level multitenancy.
- **`multitenancy-JWT-Combination`**: An advanced implementation combining row-level multitenancy with JWT authentication.

### Key Files and Directories

- **`src/main/java`**:
  - `com.example.multitenant`: Main application code.
  - `config`: Configuration files for multitenancy and JWT integration.
  - `controllers`: REST API controllers for testing and demonstration.
  - `services`: Service layer implementing the core logic.
  - `entities`: JPA entities with `tenantId` fields.
  - `repositories`: JPA repositories for database interactions.
- **`application.yml`**: Configuration file for database and other properties.
- **`README.md`**: This file.

---

## Technologies Used

- **Java**: Programming language
- **Spring Boot**: Framework for building the application
  - Spring Security for authentication
  - Spring Data JPA for database interaction
- **JWT**: Token-based authentication
- **H2/PostgreSQL/MySQL**: Database options (configurable)
- **Maven**: Dependency management

---

## Setup and Run

### Prerequisites

1. Java 17 or later installed.
2. Maven installed.
3. A database (H2 in-memory by default; others configurable in `application.yml`).
