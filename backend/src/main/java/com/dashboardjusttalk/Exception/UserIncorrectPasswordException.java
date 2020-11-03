package com.dashboardjusttalk.Exception;

import com.dashboardjusttalk.Dto.ExceptionDto;

public class UserIncorrectPasswordException extends Exception {
    public ExceptionDto exceptionDto;

    public UserIncorrectPasswordException() {
        exceptionDto = new ExceptionDto("UserIncorrectPasswordException",
                "El usuario ingresó una contraseña incorrecta");
    }
}