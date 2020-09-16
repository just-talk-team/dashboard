package com.dashboardjusttalk.domain.repository;

import com.dashboardjusttalk.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}

