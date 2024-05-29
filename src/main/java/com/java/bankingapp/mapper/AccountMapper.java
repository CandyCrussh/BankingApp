package com.java.bankingapp.mapper;

import com.java.bankingapp.dto.*;
import com.java.bankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDTO){
        Account acc = new Account(
            accountDTO.getId(),
            accountDTO.getAccountName(),
            accountDTO.getBalance()
        );
        return acc;
    }

    public static AccountDto mapToAccountDTO(Account account){
        AccountDto accountDTO = new AccountDto(
            account.getId(),
            account.getAccountName(),
            account.getBalance()
        );
        return accountDTO;
    }    
}
