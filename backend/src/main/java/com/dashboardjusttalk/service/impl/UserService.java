package com.dashboardjusttalk.service.impl;

import com.dashboardjusttalk.Dto.UserAccessDto;
import com.dashboardjusttalk.Dto.UserRegistrationDto;
import com.dashboardjusttalk.Exception.UserExistsAlreadyException;
import com.dashboardjusttalk.Exception.UserIncorrectPasswordException;
import com.dashboardjusttalk.Exception.UserLoginNotFoundException;
import com.dashboardjusttalk.Exception.UserRegistrationFailedException;
import com.dashboardjusttalk.model.User;
import com.dashboardjusttalk.repository.UserRepository;
import com.dashboardjusttalk.service.IUserService;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserAccessDto DashboardAccess(String user, String password) throws UserLoginNotFoundException,UserIncorrectPasswordException {
        String passwordEncapsulated = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        if (userRepository.existsByUserAndPassword(user,passwordEncapsulated))
        {
            User result = userRepository.getByUser(user);
            return modelMapper.map(result,UserAccessDto.class);
        } else if(userRepository.existsByUser(user)){
            throw new UserIncorrectPasswordException();
        }
    throw new UserLoginNotFoundException();
    }

    @Override
    public boolean Registration(UserRegistrationDto userRegistrationDto) throws UserRegistrationFailedException, UserExistsAlreadyException {

            boolean var = userRepository.existsByUser(userRegistrationDto.user);
            if (var) {
                throw new UserExistsAlreadyException();
            }
            userRegistrationDto.password = Hashing.sha256()
                    .hashString(userRegistrationDto.getPassword(), StandardCharsets.UTF_8)
                    .toString();
            try{
            User model = modelMapper.map(userRegistrationDto, User.class);

            userRepository.save(model);
            } catch (Exception exception) {
                throw new UserRegistrationFailedException();
            }
            return true;
    }
}
