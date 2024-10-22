# REST Application for Product and User Management

## Overview

This RESTful API is designed for managing users and products, built using Spring Boot. It offers endpoints for basic CRUD operations on both user and product entities, and includes features such as user authentication and partial updates through `PATCH` requests.

The application follows RESTful principles, using standard HTTP methods and JSON for data exchange, ensuring easy integration with front-end applications or other services.

## Features

- **User Management**: 
  - Create, read, update, and delete users.
  - Users include attributes like first name, last name, date of birth, username, and password.
  - Supports partial updates via `PATCH` method for updating specific user fields.
  
- **Product Management**:
  - CRUD operations for managing product entities.
  - Products include attributes like product ID, name, and group (e.g., electronics, home goods).
  
- **Repository Pattern**: The application uses repositories (`UserRepository`, `ProductRepository`) to interact with the database, ensuring separation of concerns and clean architecture.

## Getting Started

### Prerequisites

- **Java 11** or higher
- **Maven** (for dependency management)
- **MySQL** (for database management)
- **Postman** or any API testing tool to test the endpoints

### Setup Instructions

1. **Clone the Repository**: Clone the repository to your local machine.

2. **Database Setup**:
   - Run the `schema.sql` file to set up the necessary database tables.
   - Load initial data using the `data.sql` file.

3. **Configure Application**:
   Update the `application.properties` file with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
