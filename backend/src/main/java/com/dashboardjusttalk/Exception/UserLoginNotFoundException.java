package com.dashboardjusttalk.Exception;

import com.dashboardjusttalk.Dto.ExceptionDto;

public class UserLoginNotFoundException extends Exception {
    public ExceptionDto exceptionDto;

    public UserLoginNotFoundException() {
        exceptionDto = new ExceptionDto("UserLoginNotFoundException",
                "El usuario ingresado no se encuentra registrado");
    }
}
