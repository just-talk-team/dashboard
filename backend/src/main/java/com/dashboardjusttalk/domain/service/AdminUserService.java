package com.dashboardjusttalk.domain.service;

import com.dashboardjusttalk.domain.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class AdminUserService {
    private AdminUserRepository adminUserRepository;

    public boolean login(String username, String password) {
        return (adminUserRepository.getUserByUsernameAndPassword(username, password) != null);
    }

}

