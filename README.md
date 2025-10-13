# 🔐 Login & Registration API

A secure authentication system with Spring Boot, Spring Security, and JWT

Java Badge Spring Boot Badge Spring Security Badge JWT Badge

## 🧩 Overview

A secure and modern authentication API that handles user registration, login, and JWT token–based authorization. Designed to demonstrate real-world backend security practices with password encryption, role-based access, and stateless session management.

## ⚙️ Features

- 🧾 **User Registration** – Create new users with validation
- 🔑 **Login Authentication** – Secure login using encrypted credentials
- 🛡️ **JWT Authorization** – Stateless token-based access control
- 🔒 **Password Encryption** – Hashed using BCrypt
- 👥 **Role Management** – Support for multiple user roles (e.g., USER, ADMIN)
- 🚨 **Global Exception Handling** – Consistent and secure error responses

## 🧱 Tech Stack

| Tech | Purpose |
|------|---------|
| ☕ **Java 11+** | Core language |
| 🌿 **Spring Boot** | Framework |
| 🧩 **Spring Security** | Authentication & authorization |
| 🔐 **JWT (JSON Web Token)** | Token-based session management |
| 🧰 **Maven** | Build tool |
| 🧪 **Postman / cURL** | API testing |

## 📂 Project Structure

```
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

## ⚡ Setup & Run

### 🔧 1. Prerequisites

- Java 11 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### 🗄️ 2. Database Setup

```sql
CREATE DATABASE auth_db;
```

### ⚙️ 3. Configure Environment

Update `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# JWT Configuration
jwt.expiration=3600000
```

### ▶️ 4. Run the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using the provided script
./start.sh
```

App runs on: **http://localhost:8080**

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | 📝 Register new user |
| POST | `/api/auth/login` | 🔐 Authenticate user |
| GET | `/api/users/me` | 👤 Get logged-in user info |
| GET | `/api/admin/users` | 🧾 Admin-only: list users |

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

```
Authorization: Bearer <your_token_here>
```

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

## 🚀 Deployment Scripts

The project includes convenient deployment scripts:

### Start Application
```bash
./start.sh
```

### Stop Application
```bash
./stop.sh
```

### Deploy (Pull, Build, Start)
```bash
./deploy.sh
```

### Push to GitHub
```bash
./push.sh "Your commit message"
```

## 🔒 Security Features

- **Password Encryption**: BCrypt hashing with salt
- **JWT Tokens**: Stateless authentication with configurable expiration
- **Role-Based Access**: USER and ADMIN roles with different permissions
- **Input Validation**: Comprehensive validation for all inputs
- **Exception Handling**: Secure error responses without information leakage

## 🗄️ Database Schema

### Users Table
- `id` - Primary key
- `username` - Unique username
- `email` - Unique email address
- `password` - BCrypt hashed password
- `created_at` - Account creation timestamp
- `updated_at` - Last update timestamp

### Roles Table
- `id` - Primary key
- `name` - Role name (USER, ADMIN)

### User_Roles Table
- `user_id` - Foreign key to users
- `role_id` - Foreign key to roles

## 🚀 Future Enhancements

- 📨 **Email verification** during registration
- 🔁 **Token refresh** endpoint
- 📘 **Swagger documentation**
- �� **Docker deployment**
- 🔐 **OAuth2 integration**
- 📊 **Rate limiting**
- 📝 **Audit logging**

## 👨‍💻 Author

**MD Nawab Ali Khan**  
💼 Java Backend Developer | Open Source Enthusiast

- GitHub: [nakhandev](https://github.com/nakhandev)
- Portfolio: [Your Portfolio Link](https://your-portfolio-link.com)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Support

For support, email nakhan@example.com or create an issue on GitHub.

---

✨ **Built with ❤️ using Spring Boot + JWT** ✨
