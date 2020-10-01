package com.dashboardjusttalk.repository;

import com.dashboardjusttalk.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}

