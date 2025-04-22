package com.deepak.onlinebanking.service.impl;

import com.deepak.onlinebanking.entity.Account;
import com.deepak.onlinebanking.entity.AccountStatus;
import com.deepak.onlinebanking.repository.AccountRepository;
import com.deepak.onlinebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create a new account after checking for duplicate email or account number
    @Override
    public Account createAccount(Account account) {
        if (accountRepository.findByEmail(account.getEmail()).isPresent() ||
                accountRepository.findByAccountNumber(account.getAccountNumber()).isPresent()) {
            throw new RuntimeException("Email or Account Number already exists!");
        }
        account.setStatus(AccountStatus.ACTIVE); // Set default status
        return accountRepository.save(account);
    }

    // Retrieve account by ID, or throw error if not found
    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    // Fetch all accounts from the database
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Delete account by ID if it exists
    @Override
    public void deleteAccount(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Account does not exist!");
        }
        accountRepository.deleteById(id);
    }

    // Update the status (e.g., ACTIVE, INACTIVE) of an existing account
    @Override
    public Account updateAccountStatus(Long id, AccountStatus status) {
        Account account = getAccountById(id);
        account.setStatus(status);
        return accountRepository.save(account);
    }

    // Retrieve an account by email
    @Override
    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    // Retrieve an account by its account number
    @Override
    public Optional<Account> getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    // Retrieve all accounts by a specific status
    @Override
    public List<Account> getAccountsByStatus(AccountStatus status) {
        return accountRepository.findByStatus(status);
    }
}
