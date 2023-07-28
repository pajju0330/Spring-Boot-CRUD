# Spring Boot CRUD API Backend

This project is a simple CRUD (Create, Read, Update, Delete) API backend built using Spring Boot. It provides endpoints to manage data for a specific domain, such as "Customer," in a PostgreSQL database.

## Table of Contents

- [Technologies](#technologies)
- [Features](#features)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Setup](#setup)
- [License](#license)

## Technologies

- Java 11
- Spring Boot 2.5.x
- PostgreSQL Database

## Features

- Create a new record for a customer.
- Retrieve a specific customer record by ID.
- Retrieve all customer records.
- Update an existing customer record.
- Delete a customer record by ID.

## Getting Started

To get a local copy of the project up and running, follow these steps:

1. Ensure you have Java 11 or higher installed on your machine.
2. Set up a PostgreSQL database. Update the `application.properties` file with your database credentials.
3. Clone this repository to your local machine.
4. Open the project in your preferred Integrated Development Environment (IDE).
5. Build the project using the build tool of your choice (e.g., Maven, Gradle).
6. Run the application using your IDE or the command-line interface.

## Endpoints

| Method | Endpoint                   | Description                      |
| ------ | -------------------------- | -------------------------------- |
| POST   | /api/customers             | Create a new customer record.    |
| GET    | /api/customers             | Retrieve all customer records.   |
| GET    | /api/customers/{id}        | Retrieve a specific customer.    |
| PUT    | /api/customers/{id}        | Update an existing customer.     |
| DELETE | /api/customers/{id}        | Delete a customer record.        |

## Setup

To set up the project locally, you need to have Java 11 or higher and a PostgreSQL database installed. Here's how you can set it up:

1. Clone the repository: https://github.com/pajju0330/Spring-Boot-CRUD/

2. Open the project in your IDE.

3. Update the `application.properties` file with your PostgreSQL database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YourDatabaseName
spring.datasource.username=your-username
spring.datasource.password=your-password
```
4. build the project using Maven or Gradle:

  - For Maven:
``` mvn clean install ```

  - For Gradle:
``` ./gradlew clean build ```

## License
This project is licensed under the MIT License.
