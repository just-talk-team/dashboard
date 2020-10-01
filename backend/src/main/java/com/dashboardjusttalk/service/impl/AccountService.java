package com.dashboardjusttalk.service.impl;

import com.dashboardjusttalk.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dashboardjusttalk.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account saveAccount(Account account) {

        return repository.save(account);
    }

    public List<Account> saveAccounts(List<Account> accounts) {

        return repository.saveAll(accounts);
    }

    public List<Account> getAccounts() {

        return repository.findAll();
    }


    public Account getAccountById(int id) {

        return repository.findById(id).orElse(null);
    }


    public void deleteAccount(int id) {

        repository.deleteById(id);
    }

    public Account updateAccount(Account account) {
        Account existingAccount = repository.findById(account.getId()).orElse(null);
        existingAccount.setFirstname(account.getFirstname());
        existingAccount.setLastname(account.getLastname());
        existingAccount.setEmail(account.getEmail());
        existingAccount.setBirthdate(account.getBirthdate());
        existingAccount.setActive(account.getActive());
        return repository.save(existingAccount);
    }

}