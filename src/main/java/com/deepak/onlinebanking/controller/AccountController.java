package com.deepak.onlinebanking.controller;

import com.deepak.onlinebanking.entity.Account;
import com.deepak.onlinebanking.entity.AccountStatus;
import com.deepak.onlinebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create a new account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    // Retrieve account details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    // Fetch all registered accounts
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // Delete an account by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }

    // Update the status of an account (e.g., ACTIVE, INACTIVE)
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Account> updateAccountStatus(@PathVariable Long id, @PathVariable AccountStatus status) {
        return ResponseEntity.ok(accountService.updateAccountStatus(id, status));
    }

    // Get account by email address
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Account>> getAccountByEmail(@PathVariable String email) {
        return ResponseEntity.ok(accountService.getAccountByEmail(email));
    }

    // Get account by account number
    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<Optional<Account>> getAccountByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByAccountNumber(accountNumber));
    }

    // Get all accounts by their current status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable AccountStatus status) {
        return ResponseEntity.ok(accountService.getAccountsByStatus(status));
    }
}
