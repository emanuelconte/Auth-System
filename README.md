# Authentication System with Java, Spring Boot, and PostgreSQL

This project is a basic authentication system built with **Java**, **Spring Boot**, and **PostgreSQL**. It includes features such as user registration, login, JWT token generation, user updates, and user deletion. The system is secured using JWT-based authentication.

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **PostgreSQL**
- **Hibernate (JPA)**
- **JSON Web Token (JWT)**
- **BCrypt** (for password hashing)

## Features

- **User Registration**: Create new users with a username, email, and password.
- **Login**: Authenticate users and generate JWT tokens.
- **User Update**: Update user information (username, email, password).
- **User Deletion**: Remove users from the system.
- **Protected Routes**: Routes secured with JWT authentication.
- **Password Recovery**: Functionality to request and reset passwords (in development).
- **Simple Web Interface**: Basic pages for registration and login (optional).

## Prerequisites

Before running the project, ensure you have the following installed:

- **Java 17** (or higher)
- **PostgreSQL** (or another compatible database)
- **Maven** (for dependency management)
- **Postman** (or another tool for API testing)

## Project Setup

### 1. Clone the Repository

```bash
git clone https://github.com/emanuelconte/auth-system.git
cd auth-system
```

### 2. Database Configuration

1. Create a database in PostgreSQL named `auth_system`.
2. Configure the database credentials in the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/auth_system
spring.datasource.username=root
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Install Dependencies

Run the following command to install the project dependencies:

```bash
mvn clean install
```

### 4. Run the Project

Start the project with the following command:

```bash
mvn spring-boot:run
```

The project will be available at: `http://localhost:8080`.

---

## API Endpoints

Here are the main API endpoints:

### **User Registration**
- **Method**: `POST`
- **URL**: `/auth/register`
- **Body** (JSON):
  ```json
  {
    "username": "testuser",
    "password": "testpassword",
    "email": "testuser@example.com"
  }
  ```

### **Login**
- **Method**: `POST`
- **URL**: `/auth/login`
- **Body** (JSON):
  ```json
  {
    "username": "testuser",
    "password": "testpassword"
  }
  ```
- **Response** (JSON):
  ```json
  {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
  }
  ```

### **Update User**
- **Method**: `PUT`
- **URL**: `/users/{id}`
- **Headers**:
  - `Authorization: Bearer <token_jwt>`
- **Body** (JSON):
  ```json
  {
    "username": "updateduser",
    "email": "updateduser@example.com"
  }
  ```
### **Delete User**
- **Method**: `DELETE`
- **URL**: `/users/{id}`
- **Headers**:
  - `Authorization: Bearer <token_jwt>`

---

## Testing the Project

### 1. Manual Testing with Postman

1. **Registration**: Use the `/auth/register` endpoint to create a new user.
2. **Login**: Use the `/auth/login` endpoint to obtain a JWT token.
3. **Protected Routes**: Use the JWT token to access protected routes, such as `/users/{id}`.

### 2. Automated Testing

The project includes unit and integration tests. Run the tests with the following command:

```bash
mvn test
```

---

## Project Structure

```
src/main/java
├── auth
│   ├── sys
│   │   ├── config                # Spring Security and JWT configurations
│   │   ├── controller            # API controllers
│   │   ├── dto                   # Data Transfer Objects (DTOs)
│   │   ├── exception             # Custom exceptions
│   │   ├── model                 # Database entities
│   │   ├── repository            # JPA repositories
│   │   ├── security              # Security configurations
│   │   ├── service               # Business logic
│   │   ├── util                  # Utilities (JWT, BCrypt, etc.)
│   │   └── AuthApplication.java  # Spring Boot main class
```

---

## Contributing

Contributions are welcome! Follow these steps:

1. Fork the project.
2. Create a feature branch (`git checkout -b feature/new-feature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/new-feature`).
5. Open a Pull Request.

---

## Contact

If you have questions or suggestions, feel free to reach out:

- **Name**: Emanuel Conte
- **Email**: emanuelcontecardoso@gmail.com
- **GitHub**: emanuelconte (https://github.com/emanuelconte)
