<div align="center">

# 🛒 Challenge Supermarket API

### REST API for supermarket management built with Java & Spring Boot

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?style=for-the-badge\&logo=springboot\&logoColor=white)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.4-4479A1?style=for-the-badge\&logo=mysql\&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge\&logo=docker\&logoColor=white)](https://www.docker.com/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge\&logo=apachemaven\&logoColor=white)](https://maven.apache.org/)

<br>

**Backend-focused project implementing a RESTful API for products, branches and sales management.**

</div>

---

## 📌 About the Project

**Challenge Supermarket** is a backend application developed with **Java 21 and Spring Boot** to manage the main operations of a supermarket.

The project was designed to practice and demonstrate backend development concepts such as:

* REST API development
* Layered architecture
* CRUD operations
* DTO-based communication
* Entity mapping
* JPA/Hibernate persistence
* Relational database design
* Exception handling
* Docker containerization

The application uses **MySQL** as its database and can be started completely using **Docker Compose**.

---

## ✨ Features

### 📦 Products

* Create products
* Retrieve products
* Update products
* Delete products

### 🏪 Branches

* Create branches
* Retrieve branches
* Update branches
* Delete branches

### 💰 Sales

* Create sales
* Retrieve sales
* Update sales
* Delete sales
* Manage sale details

---

## 🏗️ Architecture

The application follows a **layered architecture**, separating responsibilities between controllers, services, repositories and domain models.

```text
                    ┌───────────────────┐
                    │      Client       │
                    │ Postman / REST    │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │    Controller     │
                    │   REST Endpoints  │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │      Service      │
                    │  Business Logic   │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │    Repository     │
                    │   Spring Data JPA │
                    └─────────┬─────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │      MySQL        │
                    │    Database       │
                    └───────────────────┘
```

### Project Structure

```text
src/main/java/
└── com/ChallengeSupermarket/ChallengeSupermarket/
    │
    ├── controller/
    │
    ├── dto/
    │
    ├── exception/
    │
    ├── mapper/
    │
    ├── model/
    │
    ├── repository/
    │
    └── service/
```

---

## 🛠️ Tech Stack

| Technology               | Purpose                       |
| ------------------------ | ----------------------------- |
| ☕ **Java 21**            | Programming language          |
| 🌱 **Spring Boot 4.1.1** | Backend framework             |
| 🌐 **Spring Web MVC**    | REST API                      |
| 🗃️ **Spring Data JPA**  | Data persistence              |
| 🔄 **Hibernate**         | ORM                           |
| 🐬 **MySQL 8.4**         | Relational database           |
| 📦 **Maven**             | Dependency management & build |
| 🐳 **Docker**            | Application containerization  |
| 🐳 **Docker Compose**    | Multi-container orchestration |
| 🔧 **Lombok**            | Boilerplate reduction         |

---

## 🔌 API

### Products

```text
GET     /api/products
POST    /api/products
PUT     /api/products/{id}
DELETE  /api/products/{id}
```

### Branches

```text
GET     /api/branches
POST    /api/branches
PUT     /api/branches/{id}
DELETE  /api/branches/{id}
```

### Sales

```text
GET     /api/sales
POST    /api/sales
PUT     /api/sales/{id}
DELETE  /api/sales/{id}
```

The endpoints can be tested using **Postman**, **Insomnia**, cURL or any REST client.

---

## 🐳 Docker

The project is fully containerized using **Docker** and **Docker Compose**.

The environment consists of two services:

```text
┌─────────────────────────────────────────────┐
│               Docker Compose                │
│                                             │
│  ┌─────────────────┐    ┌───────────────┐ │
│  │     Backend     │    │     MySQL     │ │
│  │   Spring Boot   │───▶│      8.4      │ │
│  │      :8080      │    │     :3306     │ │
│  └─────────────────┘    └───────┬───────┘ │
│                                 │         │
│                          ┌──────▼──────┐  │
│                          │   Volume    │  │
│                          │   MySQL     │  │
│                          │    Data     │  │
│                          └─────────────┘  │
└─────────────────────────────────────────────┘
```

### Multi-stage Docker Build

The backend uses a **multi-stage Dockerfile**:

```text
Build Stage
Java 21 JDK
     │
     ▼
Maven
     │
     ▼
Application JAR
     │
     ▼
Runtime Stage
Java 21 JRE
     │
     ▼
Spring Boot Application
```

This approach keeps the final runtime image smaller by separating the build environment from the application runtime.

---

## 🚀 Getting Started

### Requirements

* Docker Desktop
* Git

No local Java or MySQL installation is required when running the application with Docker.

### Clone the repository

```bash
git clone https://github.com/FedericoBrid/ChallengeSupermarket.git
cd ChallengeSupermarket
```

### Start the application

```bash
docker compose up --build
```

Docker Compose will:

1. Build the Spring Boot application.
2. Start MySQL.
3. Wait until MySQL is healthy.
4. Start the backend.
5. Connect Spring Boot to MySQL through the Docker network.

### API

Once the containers are running:

```text
http://localhost:8080
```

Example:

```http
GET http://localhost:8080/api/products
```

### Stop the application

```bash
docker compose down
```

---

## 🗄️ Database

The application uses **MySQL 8.4**.

Main entities:

```text
Branch
   │
   └── Sale
         │
         └── SaleDetail
                 │
                 └── Product
```

Hibernate/JPA manages the entity relationships and database schema.

The project uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

so Hibernate can update the schema according to the entity definitions.

---

## ⚙️ Configuration

Database configuration supports environment variables, allowing the same application to work both locally and inside Docker.

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL:jdbc:mysql://localhost:3306/challenge_supermarket}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME:root}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD:root}
```

Inside Docker Compose, the backend connects to MySQL using the service name:

```text
mysql:3306
```

rather than `localhost`.

---

## 📁 Project Structure

```text
ChallengeSupermarket/
│
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ChallengeSupermarket/ChallengeSupermarket/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── exception/
│   │   │       ├── mapper/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── .dockerignore
├── .gitignore
├── Dockerfile
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🎯 What I Practiced

This project allowed me to work with:

* Java 21
* Spring Boot
* RESTful API design
* Spring Data JPA
* Hibernate
* MySQL
* DTOs and mappers
* Layered architecture
* Entity relationships
* CRUD operations
* Exception handling
* Docker
* Docker Compose
* Multi-stage Docker builds
* Environment-based configuration

