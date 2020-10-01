package com.dashboardjusttalk.controller;

import com.dashboardjusttalk.Dto.UserLoginDto;
import com.dashboardjusttalk.Dto.UserRegistrationDto;
import com.dashboardjusttalk.Exception.UserExistsAlreadyException;
import com.dashboardjusttalk.Exception.UserIncorrectPasswordException;
import com.dashboardjusttalk.Exception.UserLoginNotFoundException;
import com.dashboardjusttalk.Exception.UserRegistrationFailedException;
import com.dashboardjusttalk.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("user")
    public ResponseEntity<?> ValidateLogin(@RequestBody UserLoginDto userLoginDto) {
        try {
            return ResponseEntity.status(200).body(userService.DashboardAccess(userLoginDto.user, userLoginDto.password));
        } catch (UserLoginNotFoundException exception) {
            return ResponseEntity.status(400).body(exception.exceptionDto);
        }catch (UserIncorrectPasswordException exception){
            return ResponseEntity.status(400).body(exception.exceptionDto);
        }
    }
    @PostMapping("user/registration")
    public ResponseEntity<?> Registration(@RequestBody UserRegistrationDto userRegistrationDto){
        try{
            return ResponseEntity.status(200).body(userService.Registration(userRegistrationDto));
        }catch (UserRegistrationFailedException exception){
            return ResponseEntity.status(400).body(exception.exceptionDto);
        }catch (UserExistsAlreadyException exception){
            return ResponseEntity.status(400).body(exception.exceptionDto);
        }
    }

}


