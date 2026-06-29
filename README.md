# 🚗 Auto Auction System

A backend RESTful web application built using **Java**, **Spring Boot**, and **MySQL** that enables users to manage vehicle auctions, place bids, and track auction activities.

---

## 📖 Overview

The Auto Auction System provides APIs for managing vehicles and auctions. Users can create vehicle listings, place bids, retrieve bid history, and determine the highest bidder in real time.

The application follows a layered architecture using Spring Boot best practices.

---

## ✨ Features

- Vehicle Management (CRUD)
- Auction Management
- Place Bids on Vehicles
- View Bid History
- Retrieve Highest Bid and Bidder Details
- Input Validation
- Exception Handling
- RESTful APIs
- MySQL Database Integration

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Postman
- Git & GitHub

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   ├── exception
│   │   ├── config
│   │   └── AutoAuctionApplication.java
│   └── resources
│       ├── application.properties
│       └── data.sql (optional)
└── test
```

---

## ⚙️ Setup Instructions

### Clone Repository

```bash
git clone https://github.com/yourusername/auto-auction-system.git
```

### Navigate to Project

```bash
cd auto-auction-system
```

### Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/autoauction
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on

```
http://localhost:8080
```

---

## 📌 REST APIs

### Vehicle APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /vehicles | Add Vehicle |
| GET | /vehicles | Get All Vehicles |
| GET | /vehicles/{id} | Get Vehicle |
| PUT | /vehicles/{id} | Update Vehicle |
| DELETE | /vehicles/{id} | Delete Vehicle |

---

### Auction APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /auctions | Create Auction |
| GET | /auctions | Get All Auctions |
| GET | /auctions/{id} | Auction Details |

---

### Bid APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /bids | Place Bid |
| GET | /bids/vehicle/{vehicleId} | Bid History |
| GET | /bids/highest/{vehicleId} | Highest Bid with Bidder |

---

## 📊 Architecture

```
Client
   │
REST API
   │
Controller
   │
Service
   │
Repository
   │
MySQL Database
```

---

## ✅ Validation

- Vehicle details validation
- Bid amount validation
- Auction status validation
- Request validation using Bean Validation

---

## 🛡 Exception Handling

- Resource Not Found
- Invalid Bid Amount
- Validation Errors
- Global Exception Handler

---

## 🧪 Testing

The APIs can be tested using:

- Postman
- Swagger (optional)

---

## 🚀 Future Enhancements

- JWT Authentication
- User Registration & Login
- Email Notifications
- Auction Expiry Scheduler
- Payment Integration
- Image Upload for Vehicles
- Docker Support
- CI/CD Pipeline

---

## 👨‍💻 Author

**Sarveesh**

Backend Developer

Skills:
- Java
- Spring Boot
- REST APIs
- MySQL
- Hibernate
- Git
- Maven

---

## 📄 License

This project is intended for learning and portfolio purposes.
