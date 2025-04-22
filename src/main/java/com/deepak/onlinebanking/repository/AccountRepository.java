package com.deepak.onlinebanking.repository;

import com.deepak.onlinebanking.entity.Account;
import com.deepak.onlinebanking.entity.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  // Marks this interface as a Spring Data JPA repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Find an account by email (ensures unique email constraint)
    Optional<Account> findByEmail(String email);

    // Find an account by account number (ensures unique account number)
    Optional<Account> findByAccountNumber(String accountNumber);

    // Find all accounts based on their status (ACTIVE, INACTIVE, BLOCKED)
    List<Account> findByStatus(AccountStatus status);

}
