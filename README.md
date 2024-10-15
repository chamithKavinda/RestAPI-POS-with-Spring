# Point of Sale (POS) System REST API

This project is a REST API for a Point of Sale (POS) system, implemented using the Spring framework. The API allows for the management of customers, products, and orders, with full CRUD (Create, Read, Update, Delete) operations. It uses MySQL as the database and Hibernate for Object-Relational Mapping (ORM), and includes validation to ensure data integrity. API documentation is available via Postman.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Validation](#validation)
- [Database Schema](#database-schema)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Documentation](#documentation)
- [Contributors](#contributors)
- [License](#license)

## Features

- Manage customers, products, and orders.
- Perform CRUD operations for all entities.
- Includes input validation for data consistency.
- Uses Hibernate for ORM and MySQL as the database.
- Postman documentation is available for API testing.

## Technologies Used

- **Spring Framework** (Spring Boot, Spring Data JPA)
- **Hibernate** for ORM
- **MySQL** as the relational database
- **Postman** for API documentation
- **Maven** for project management
- **Java** as the programming language

## Configuration

- Database settings and Hibernate configurations are defined in the `application.properties` file.
- You need to specify your MySQL database connection details in this file.

## Usage

The API supports operations to manage customers, products, and orders. Here’s how you can interact with the API:

### API Endpoints

- **Customers**
  - `GET /api/customers` - Retrieve all customers
  - `GET /api/customers/{id}` - Retrieve a customer by ID
  - `POST /api/customers` - Add a new customer
  - `PUT /api/customers/{id}` - Update a customer
  - `DELETE /api/customers/{id}` - Delete a customer

- **Products**
  - `GET /api/products` - Retrieve all products
  - `GET /api/products/{id}` - Retrieve a product by ID
  - `POST /api/products` - Add a new product
  - `PUT /api/products/{id}` - Update a product
  - `DELETE /api/products/{id}` - Delete a product

- **Orders**
  - `GET /api/orders` - Retrieve all orders
  - `GET /api/orders/{id}` - Retrieve an order by ID
  - `POST /api/orders` - Create a new order
  - `PUT /api/orders/{id}` - Update an order
  - `DELETE /api/orders/{id}` - Cancel an order

## Validation

The application implements input validation to ensure data meets the required formats and business rules, including:

- Non-null constraints for fields such as customer names and product prices.
- Proper email formatting for customer contacts.
- Length constraints for text fields where applicable.

## Database Schema

The MySQL database schema includes the following tables:

- **Customer**: `id`, `name`, `email`, `phone`
- **Product**: `id`, `name`, `price`, `quantity`
- **Order**: `id`, `customer_id`, `order_date`, `total_amount`

## Examples

Use Postman to test the API endpoints. You can import the [[Postman documentation](link to Postman documentation)](https://documenter.getpostman.com/view/35385399/2sAXxTdWVj) to get started with sample requests.

## Troubleshooting

- **Database Connection Issues**: Verify the database credentials and connection settings in the `application.properties` file.
- **Build Failures**: Check for missing or incompatible dependencies in the `pom.xml` file.
- **API Not Responding**: Ensure the application is running on the specified port (default is 8080).

## Documentation

For detailed API documentation, refer to the Postman documentation [[here](link to Postman documentation)](https://documenter.getpostman.com/view/35385399/2sAXxTdWVj).

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
