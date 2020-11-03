package com.dashboardjusttalk.controller;
import com.dashboardjusttalk.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.dashboardjusttalk.model.Account;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8086")
@RequestMapping("dashboard/api/accounts")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account saveAccount(@RequestBody Account account) {

        return accountService.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAccounts() {

        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id) {

        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@RequestBody Account Account, @PathVariable int id) {
        return accountService.updateAccount(Account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id) {

        accountService.deleteAccount(id);
    }
}
