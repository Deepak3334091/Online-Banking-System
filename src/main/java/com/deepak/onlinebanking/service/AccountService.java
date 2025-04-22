package com.deepak.onlinebanking.service;

import com.deepak.onlinebanking.entity.Account;
import com.deepak.onlinebanking.entity.AccountStatus;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long id);

    List<Account> getAllAccounts();

    void deleteAccount(Long id);

    Account updateAccountStatus(Long id, AccountStatus status);

    // NEW METHODS (from repository)
    Optional<Account> getAccountByEmail(String email);

    Optional<Account> getAccountByAccountNumber(String accountNumber);

    List<Account> getAccountsByStatus(AccountStatus status);
}
