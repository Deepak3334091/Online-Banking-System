# Online Banking System

A simple and secure online banking system built using **Spring Boot**, **MySQL**, and **Spring Security**. This application allows users to create accounts, manage their balances, and perform banking operations such as fund transfers, account creation, and status updates.

## Features

- **Account Management**:
  - Create a new account
  - Update account details
  - Delete accounts
  - Get account by ID, email, or account number

- **Fund Management**:
  - Check account balance
  - Transfer funds between accounts

- **User Roles**:
  - Admin: Full access to all features
  - Manager: Can manage departments and view account details
  - Employee: Limited access based on assigned role

- **Security**:
  - Role-based authentication and authorization using **Spring Security**
  - Password encryption using **BCrypt**

## Technologies Used

- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **Authentication**: Spring Security, BCrypt
- **JPA/Hibernate**: For database ORM
- **Dev Tools**: Spring DevTools for hot reload

## Setup Instructions

### Prerequisites

- Java 17 or higher
- MySQL 8 or higher
- Maven for dependency management

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Deepak3334091/Online-Banking-System.git
