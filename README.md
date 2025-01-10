# Fitness and Health REST Application

## Overview
This project is a Spring Boot-based RESTful application designed to manage fitness and health-related data. It includes comprehensive APIs for handling users, subscriptions, payments, user balances, and fitness plans. With robust service implementations and database repositories, this application provides a scalable backend solution suitable for integration with client applications or third-party systems.

## Features
### User Management
- Create, update, delete, and retrieve user profiles.
- Track user-specific fitness goals, plans, and subscriptions.

### Subscription Management
- Manage user subscriptions to fitness plans, including start and end dates and associated costs.

### Payment Processing
- Handle payment transactions, storing details like type, amount, and date.

### User Balance Management
- Manage user account balances for fitness-related transactions.

### Fitness Plan Management
- Define and manage fitness plans, including training routines, nutrition plans, or combinations.

## Technologies Used
- **Backend Framework:** Spring Boot
- **Programming Language:** Java
- **Database:** Relational database (e.g., MySQL, PostgreSQL)
- **Build Tool:** Maven
- **Data Format:** JSON
- **Dependency Injection:** Spring Framework
- **ORM/Template Engine:** JdbcTemplate


## API Endpoints
### User Controller
- `GET /user` - Retrieve all users.
- `GET /user/{id}` - Retrieve a user by ID.
- `POST /user` - Create a new user.
- `PUT /user/{id}` - Update an existing user by ID.
- `DELETE /user/{id}` - Delete a user by ID.

### Subscription Controller
- `GET /subscription` - Retrieve all subscriptions.
- `GET /subscription/{id}` - Retrieve a subscription by ID.
- `POST /subscription` - Create a new subscription.
- `DELETE /subscription/{id}` - Delete a subscription by ID.

### Payment Controller
- `GET /payment` - Retrieve all payments.
- `GET /payment/{id}` - Retrieve a payment by ID.
- `POST /payment` - Create a new payment.
- `DELETE /payment/{id}` - Delete a payment by ID.

### User Balance Controller
- `GET /userbalance` - Retrieve all user balances.
- `GET /userbalance/{id}` - Retrieve a user balance by ID.
- `POST /userbalance` - Create a new user balance.
- `PUT /userbalance/{id}` - Update a user balance by ID.
- `DELETE /userbalance/{id}` - Delete a user balance by ID.

### Plan Controller
- `GET /plan` - Retrieve all fitness plans.
- `GET /plan/{id}` - Retrieve a fitness plan by ID.
- `POST /plan` - Create a new fitness plan.
- `PUT /plan/{id}` - Update an existing fitness plan by ID.
- `DELETE /plan/{id}` - Delete a fitness plan by ID.

## Setup Instructions
### Prerequisites
- Java 11 or higher
- Maven
- A relational database (e.g., MySQL)

### Steps
1. **Clone the repository:**
   ```bash
   git clone <repository_url>
   cd <repository_folder>
2. **Configure the databse:**
  spring.datasource.url=jdbc:mysql://localhost:3306/your_database
  spring.datasource.username=your_username
  spring.datasource.password=your_password
3. **Build the Project:**
  mvn clean install
4. **Run the Application:**
  mvn spring-boot:run
5. **Access the API:**
  http://localhost:8080