package com.java.bankingapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.bankingapp.dto.AccountDto;
import com.java.bankingapp.entity.Account;
import com.java.bankingapp.mapper.AccountMapper;
import com.java.bankingapp.repository.AccountRepository;
import com.java.bankingapp.service.AccountService;

@Service
public class AccountImpl implements AccountService{

    private AccountRepository acc;

    public AccountImpl(AccountRepository acc) {
        this.acc = acc;
    }

    @Override
    public AccountDto createAccount(AccountDto accountdto) {
        System.out.println("service layer called");
        Account account = AccountMapper.mapToAccount(accountdto) ;
        Account savedAccount = acc.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);   
    }

    @Override
    public Optional<AccountDto> get(Long id) {
        return acc.findById(id).map(AccountMapper::mapToAccountDTO);
    }

    @Override
    public List<AccountDto> getAll() {
        return acc.findAll()
                .stream()
                .map(AccountMapper::mapToAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteId(Long id) {
        acc.deleteById(id);
    }

    @Override
    public void deleteAll() {
        acc.deleteAll();
    }

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = acc.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient amount");
		}
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount = acc.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = acc.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exist"));
//		if(account.getBalance()>amount) {
//			throw new RuntimeException("Insufficient amount");
//		}
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = acc.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
	}

}
