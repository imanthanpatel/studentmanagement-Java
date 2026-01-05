# 🎓 Student Management System

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-Enabled-success?style=flat-square&logo=springsecurity)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=flat-square&logo=apachemaven)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-yellow?style=flat-square&logo=hibernate)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue?style=flat-square&logo=mysql)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template-green?style=flat-square&logo=thymeleaf)
![Status](https://img.shields.io/badge/Project-In%20Progress-yellow?style=flat-square)

---

## 📘 About the Project

The **Student Management System** is a backend-focused web application built using **Java 17** and **Spring Boot**.  
It provides a structured and secure way to manage students and courses while following **industry-standard backend practices**.

This project is developed to strengthen real-world skills in:
- Spring Boot architecture
- Security implementation
- Exception handling
- Transaction management
- Clean & maintainable code

---

## 🚀 Features

- 🔐 Authentication & Authorization (Spring Security)
- 👤 Student CRUD Operations
- 📚 Course Management
- 🔄 DTO & Mapper Pattern
- 🧾 Custom Repository Queries
- ⚠️ Global Exception Handling
- 📜 Centralized Logging (Logback XML)
- 🌐 Thymeleaf-based UI
- 🧠 Transaction Management using `@Transactional`

---

## 🛠️ Tech Stack

| Technology | Description |
|----------|-------------|
| Java 17 | Core programming language |
| Spring Boot | Backend framework |
| Spring Security | Authentication & Authorization |
| Spring Data JPA | ORM & database interaction |
| Hibernate | JPA implementation |
| Thymeleaf | Server-side templating |
| MySQL / H2 | Database |
| Logback | Logging |
| Maven | Dependency management |

---

## 🏗️ Project Architecture

```text
src/main/java
└── com.example.sms
    ├── controller        # Handles HTTP requests
    ├── service           # Business logic layer
    ├── repository        # Database access layer
    ├── dto               # Data Transfer Objects
    ├── mapper            # DTO ↔ Entity mapping
    ├── entity            # JPA entity classes
    ├── exception         # Custom exceptions & global handler
    ├── security          # Spring Security configuration
    └── configurations    # Application & bean configurations
```

## ⭐ Give a Star

If you like this project, don’t forget to ⭐ the repository!
