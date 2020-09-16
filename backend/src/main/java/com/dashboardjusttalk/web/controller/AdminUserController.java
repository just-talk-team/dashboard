package com.dashboardjusttalk.web.controller;

import com.dashboardjusttalk.domain.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8086")
@RequestMapping("dashboard/api/")
@RestController
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @PostMapping(value = "login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password){
        if(adminUserService.login(username,password)){
            return "Usuario valido :)";
        }
        return "Usuario inválido :(";
    }

}