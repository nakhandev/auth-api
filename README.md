<!-- 🔐 Login & Registration API - Secure Auth System -->

<h1 align="center">🔐 Login & Registration API</h1>
<h3 align="center">A secure authentication system with <span style="color:#6DB33F;">Spring Boot</span>, <span style="color:#00758F;">Spring Security</span>, and <span style="color:#E76F00;">JWT</span></h3>

<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/Java-11+-E76F00?style=for-the-badge&logo=openjdk&logoColor=white">
    <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Java-11+-F89820?style=for-the-badge&logo=openjdk&logoColor=black">
    <img alt="Java Badge" src="https://img.shields.io/badge/Java-11+-E76F00?style=for-the-badge&logo=openjdk&logoColor=white">
  </picture>
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/Spring%20Boot-2.7.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
    <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Spring%20Boot-2.7.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=black">
    <img alt="Spring Boot Badge" src="https://img.shields.io/badge/Spring%20Boot-2.7.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  </picture>
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/Spring%20Security-5.x-68B587?style=for-the-badge&logo=springsecurity&logoColor=white">
    <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/Spring%20Security-5.x-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=black">
    <img alt="Spring Security Badge" src="https://img.shields.io/badge/Spring%20Security-5.x-68B587?style=for-the-badge&logo=springsecurity&logoColor=white">
  </picture>
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/JWT-Authorization-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white">
    <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/JWT-Authorization-FBBA00?style=for-the-badge&logo=jsonwebtokens&logoColor=black">
    <img alt="JWT Badge" src="https://img.shields.io/badge/JWT-Authorization-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white">
  </picture>
</p>

---

## 🧩 Overview

A **secure and modern authentication API** that handles **user registration**, **login**, and **JWT token–based authorization**.  
Designed to demonstrate real-world backend security practices with **password encryption**, **role-based access**, and **stateless session management**.

---

## ⚙️ Features

- 🧾 **User Registration** – Create new users with validation  
- 🔑 **Login Authentication** – Secure login using encrypted credentials  
- 🛡️ **JWT Authorization** – Stateless token-based access control  
- 🔒 **Password Encryption** – Hashed using BCrypt  
- 👥 **Role Management** – Support for multiple user roles (e.g., USER, ADMIN)  
- 🚨 **Global Exception Handling** – Consistent and secure error responses  

---

## 🧱 Tech Stack

| Tech | Purpose |
|------|----------|
| ☕ **Java 11+** | Core language |
| 🌿 **Spring Boot** | Framework |
| 🧩 **Spring Security** | Authentication & authorization |
| 🔐 **JWT (JSON Web Token)** | Token-based session management |
| 🧰 **Maven** | Build tool |
| 🧪 **Postman / cURL** | API testing |

---

## 📂 Project Structure
```bash
auth-api/
├── controller/        # Auth endpoints
├── service/           # Business logic
├── repository/        # User data access
├── model/             # Entities (User, Role)
├── security/          # JWT, filters, configs
└── resources/
    ├── application.properties
    └── data.sql (optional)
```

---

## ⚡ Setup & Run

### 🔧 1. Clone the repo
```bash
git clone https://github.com/nakhandev/auth-api.git
cd login-registration-api
```

### ⚙️ 2. Configure Environment (`application.properties`)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
spring.datasource.username=nakdev
spring.datasource.password=Linux@1998
spring.jpa.hibernate.ddl-auto=update
jwt.secret=yourSecretKey
jwt.expiration=3600000
```

### ▶️ 3. Run the App
```bash
mvn spring-boot:run
```
> App runs on: **http://localhost:8080**

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/auth/register` | 📝 Register new user |
| `POST` | `/api/auth/login` | 🔐 Authenticate user |
| `GET` | `/api/users/me` | 👤 Get logged-in user info |
| `GET` | `/api/admin/users` | 🧾 Admin-only: list users |

---

## 🧾 Example Requests

### ➕ Registration
```json
{
  "username": "nakhan",
  "email": "nakhan@example.com",
  "password": "securePass123"
}
```

### 🔑 Login
```json
{
  "email": "nakhan@example.com",
  "password": "securePass123"
}
```

### 🔒 Authenticated Request
Use the JWT token in the header:
```http
Authorization: Bearer <your_token_here>
```

---

## ⚠️ Error Response Example
```json
{
  "timestamp": "2025-10-14T12:45:32Z",
  "status": 401,
  "error": "Unauthorized",
  "message": "Invalid credentials",
  "path": "/api/auth/login"
}
```

---

## 🚀 Future Enhancements

- 📨 Email verification during registration  
- 🔁 Token refresh endpoint  
- 📘 Swagger documentation  
- 🐳 Docker deployment  

---

## 👨‍💻 Author

**[MD Nawab Ali Khan](https://github.com/nakhandev)**  
💼 *Java Backend Developer | Open Source Enthusiast*  

<p align="center">
  <a href="https://github.com/nakhandev">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/GitHub-nakhandev-181717?style=for-the-badge&logo=github&logoColor=white">
      <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/GitHub-nakhandev-F0F0F0?style=for-the-badge&logo=github&logoColor=black">
      <img alt="GitHub Profile" src="https://img.shields.io/badge/GitHub-nakhandev-181717?style=for-the-badge&logo=github&logoColor=white">
    </picture>
  </a>
  <a href="https://nakhandev.github.io">
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://img.shields.io/badge/🌐%20Portfolio-nakhandev.github.io-0078D7?style=for-the-badge">
      <source media="(prefers-color-scheme: light)" srcset="https://img.shields.io/badge/🌐%20Portfolio-nakhandev.github.io-0A66C2?style=for-the-badge">
      <img alt="Portfolio Link" src="https://img.shields.io/badge/🌐%20Portfolio-nakhandev.github.io-0078D7?style=for-the-badge">
    </picture>
  </a>
</p>

---

<p align="center">✨ Built with ❤️ using <b>Spring Boot + JWT</b> ✨</p>
