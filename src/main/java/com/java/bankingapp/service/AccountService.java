package com.java.bankingapp.service;

import java.util.List;
import java.util.Optional;

import com.java.bankingapp.dto.AccountDto;
// import com.bankingapp.entity.Account;

public interface AccountService {

    AccountDto createAccount(AccountDto accountdto);

    Optional<AccountDto> get(Long id);
    
    AccountDto withdraw(Long id, double amount);
    
    AccountDto deposit(Long id, double amount);

    List<AccountDto> getAll();

    // AccountDTO update(AccountDTO account);

    void deleteId(Long id);

    void deleteAll();

}
