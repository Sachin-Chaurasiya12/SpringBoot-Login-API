# 🔐 SpringBoot Login API

A secure authentication REST API built using **Spring Boot** and **JWT (JSON Web Token)** for user login and registration.

This project demonstrates how to implement **stateless authentication** using **JWT** with **Spring Security**.

---

## 🚀 Features

* User Registration
* User Login Authentication
* JWT Token Generation
* Secure API Endpoints
* Stateless Authentication
* Password Encryption using BCrypt
* MySQL Database Integration
* Spring Security Configuration
* Custom JWT Filter

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Maven
* MySQL
* JPA / Hibernate

---

## 📁 Project Structure

```
src/main/java/com/practice/security

├── config
│   ├── SecurityConfig.java
│   └── JwtFilter.java
│
├── controller
│   └── AuthController.java
│
├── service
│   ├── JwtService.java
│   └── MyUserDetailsService.java
│
├── repository
│   └── UserRepository.java
│
├── model
│   └── Users.java
│
└── SecurityApplication.java
```

---

## 🔑 Authentication Flow

1. User registers using `/register`
2. User logs in using `/login`
3. Server authenticates credentials
4. JWT token is generated
5. Client sends token in request header

```
Authorization: Bearer <JWT_TOKEN>
```

6. JWT Filter validates the token
7. Access is granted to protected APIs

---

## 📡 API Endpoints

### Register User

```
POST /register
```

Request Body

```json
{
  "username": "sachin",
  "password": "password123"
}
```

---

### Login

```
POST /login
```

Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

### Access Protected API

```
GET /users
```

Header

```
Authorization: Bearer JWT_TOKEN
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone Repository

```bash
git clone https://github.com/Sachin-Chaurasiya12/SpringBoot-Login-API.git
```

### 2️⃣ Navigate to Project

```bash
cd SpringBoot-Login-API
```

### 3️⃣ Configure Database

Update `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=yourpassword
```

---

### 4️⃣ Run Application

```bash
mvn spring-boot:run
```

Server starts on

```
http://localhost:8080
```

---

## 🔒 Security

* Passwords encrypted using **BCrypt**
* Stateless authentication using **JWT**
* Protected endpoints require a valid token

---

## 📜 License

This project is licensed under the **GPL-3.0 License**.

---

## 👨‍💻 Author

Sachin Chaurasiya

GitHub:
https://github.com/Sachin-Chaurasiya12

---

⭐ If you like this project, consider giving it a star!
