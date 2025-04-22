package com.deepak.onlinebanking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")  // Specifies the table name in the database
public class Account {

    @Id  // Primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generated ID
    private Long id;

    @Column(nullable = false, unique = true)  // Ensures account number is unique and not null
    private String accountNumber;

    @NotNull  // Ensures user name is not null
    private String userName;

    @Email  // Ensures email format is valid
    @Column(nullable = false, unique = true)  // Ensures email is unique and not null
    private String email;

    @NotNull  // Ensures password is not null
    private String password;

    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")  // Defines balance with 2 decimal places and default value 0.00
    private Double balance;

    @Enumerated(EnumType.STRING)  // Stores enum values as strings in the database
    private AccountType accountType;

    private LocalDateTime createdAt;  // Stores account creation timestamp
    private LocalDateTime updatedAt;  // Stores last update timestamp

    @PrePersist  // Executes before inserting a new record
    protected void onCreate() {
        createdAt = LocalDateTime.now();  // Set created timestamp when inserting
        updatedAt = LocalDateTime.now();  // Also set updated timestamp at creation
    }

    @PreUpdate  // Executes before updating an existing record
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();  // Update timestamp when modifying
    }

    @Enumerated(EnumType.STRING)  // Stores enum values as strings in the database
    private AccountStatus status;

    // Default constructor
    public Account() {}

    // Constructor to initialize Account with values
    public Account(String accountNumber, String userName, String email, String password, Double balance, AccountType accountType, AccountStatus status) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.accountType = accountType;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    // Override toString method for better string representation of Account object
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }
}
