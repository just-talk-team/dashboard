package com.dashboardjusttalk.domain.service;

import org.modelmapper.ModelMapper;
import com.dashboardjusttalk.persistence.entity.AdminUser;
import com.dashboardjusttalk.domain.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    public boolean login(String username, String password) {
        return (adminUserRepository.getUserByUsernameAndPassword(username, password) != null);
    }

}

