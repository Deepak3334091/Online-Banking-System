package com.deepak.onlinebanking.service;

import com.deepak.onlinebanking.entity.Account;
import com.deepak.onlinebanking.entity.AccountStatus;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    // Method to create a new account
    Account createAccount(Account account);

    // Method to retrieve an account by its ID
    Account getAccountById(Long id);

    // Method to get all accounts in the system
    List<Account> getAllAccounts();

    // Method to delete an account by its ID
    void deleteAccount(Long id);

    // Method to update the status of an account
    Account updateAccountStatus(Long id, AccountStatus status);

    // NEW METHODS (from repository)

    // Method to retrieve an account by email
    Optional<Account> getAccountByEmail(String email);

    // Method to retrieve an account by its account number
    Optional<Account> getAccountByAccountNumber(String accountNumber);

    // Method to get a list of accounts by their status (e.g., ACTIVE, INACTIVE)
    List<Account> getAccountsByStatus(AccountStatus status);
}
