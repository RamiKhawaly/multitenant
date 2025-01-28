# Row-Level Multitenancy Implementation in Spring Boot

This repository demonstrates how to implement **row-level multitenancy** using Spring Boot. Each object in the application contains a field called `tenantId` to segregate data by tenants. The repository also includes an advanced implementation combining **JWT (JSON Web Token)** authentication with multitenancy, available in the branch `multitenancy-JWT-Combination`.

---

## Table of Contents

- [Overview](#overview)
- [Branches](#branches)
  - [Main Branch](#main-branch)
  - [multitenancy-JWT-Combination Branch](#multitenancy-jwt-combination-branch)
- [Technologies Used](#technologies-used)
- [Setup and Run](#setup-and-run)
- [Features](#features)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

**Multitenancy** allows multiple tenants (e.g., organizations or users) to share a single application instance while maintaining data isolation. This project demonstrates how to implement row-level multitenancy where each database entity includes a `tenantId` field to identify the associated tenant.

In the advanced branch (`multitenancy-JWT-Combination`), **JWT authentication** is integrated with multitenancy. Upon logging in, the user receives a JWT containing their `tenantId`, ensuring requests are processed securely within the tenant's scope.

---

## Branches

### Main Branch

The main branch provides a basic implementation of **row-level multitenancy**. It includes:
- Entity design with `tenantId` as a mandatory field.
- Query filtering based on `tenantId` to enforce data isolation.

### multitenancy-JWT-Combination Branch

This branch builds on the main branch by integrating **JWT authentication**:
- Users log in to retrieve a JWT containing their `tenantId`.
- Each request is authenticated using the token, ensuring actions are scoped to the correct tenant.
- Middleware and interceptors automatically inject `tenantId` into queries based on the JWT.

---

## Technologies Used

- **Java**: Programming language
- **Spring Boot**: Framework for building the application
  - Spring Security for authentication
  - Spring Data JPA for database interaction
- **JWT**: Token-based authentication
- **H2/PostgreSQL/MySQL**: Database options (easily configurable)
- **Maven**: Dependency management

---

## Setup and Run

### Prerequisites

1. Java 17 or later installed.
2. Maven installed.
3. A database (H2 in-memory by default; others can be configured in `application.yml`).

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/multitenancy-demo.git
   cd multitenancy-demo
