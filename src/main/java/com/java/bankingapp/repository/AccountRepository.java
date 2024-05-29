package com.java.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
