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

    // ✅ 1. Create a new account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    // ✅ 2. Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    // ✅ 3. Get all accounts
    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    // ✅ 4. Delete an account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }

    // ✅ 5. Update account status
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Account> updateAccountStatus(@PathVariable Long id, @PathVariable AccountStatus status) {
        return ResponseEntity.ok(accountService.updateAccountStatus(id, status));
    }

    // ✅ 6. Get account by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Account>> getAccountByEmail(@PathVariable String email) {
        return ResponseEntity.ok(accountService.getAccountByEmail(email));
    }

    // ✅ 7. Get account by account number
    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<Optional<Account>> getAccountByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByAccountNumber(accountNumber));
    }

    // ✅ 8. Get accounts by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable AccountStatus status) {
        return ResponseEntity.ok(accountService.getAccountsByStatus(status));
    }
}
