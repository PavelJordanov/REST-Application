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

4. **Run the Application**:
Navigate to the project directory and run the following commands:

```bash
mvn clean install
mvn spring-boot:run
This will build and start the Spring Boot application. Once running, the API will be accessible at:
http://localhost:8080

5. **Access the API**:

Use an API testing tool like **Postman** to test the endpoints.

- To get all products: 
  - `GET` request to `/product`
- To create a new user:
  - `POST` request to `/user`
- To update a product:
  - `PUT` request to `/product/{id}`

6. **API Endpoints**:
### Product Endpoints

| HTTP Method | Endpoint         | Description                     |
|-------------|------------------|---------------------------------|
| `GET`       | `/product`        | Retrieve all products           |
| `GET`       | `/product/{id}`   | Retrieve a product by ID        |
| `POST`      | `/product`        | Create a new product            |
| `PUT`       | `/product/{id}`   | Update a product by ID          |
| `DELETE`    | `/product/{id}`   | Delete a product by ID          |

### User Endpoints

| HTTP Method | Endpoint         | Description                     |
|-------------|------------------|---------------------------------|
| `GET`       | `/user`           | Retrieve all users              |
| `GET`       | `/user/{id}`      | Retrieve a user by ID           |
| `POST`      | `/user`           | Create a new user               |
| `PUT`       | `/user/{id}`      | Update a user by ID             |
| `PATCH`     | `/user/{id}`      | Partially update a user by ID   |
| `DELETE`    | `/user/{id}`      | Delete a user by ID             |

### Example Request - Create a User

```json
{
  "firstname": "John",
  "lastname": "Doe",
  "dob": "1990-01-01",
  "username": "johndoe",
  "password": "password123"
}
