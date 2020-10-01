package com.dashboardjusttalk.service;

import com.dashboardjusttalk.Dto.UserAccessDto;
import com.dashboardjusttalk.Dto.UserRegistrationDto;
import com.dashboardjusttalk.Exception.UserExistsAlreadyException;
import com.dashboardjusttalk.Exception.UserIncorrectPasswordException;
import com.dashboardjusttalk.Exception.UserLoginNotFoundException;
import com.dashboardjusttalk.Exception.UserRegistrationFailedException;

public interface IUserService {
    UserAccessDto DashboardAccess(String user, String password) throws UserLoginNotFoundException, UserIncorrectPasswordException;
    boolean Registration(UserRegistrationDto userRegistrationDto) throws UserRegistrationFailedException, UserExistsAlreadyException;
}
