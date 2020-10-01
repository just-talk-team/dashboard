package com.dashboardjusttalk.Exception;

import com.dashboardjusttalk.Dto.ExceptionDto;

public class UserExistsAlreadyException  extends Exception {
    public ExceptionDto exceptionDto;

    public UserExistsAlreadyException() {
        exceptionDto = new ExceptionDto("UserExistsAlreadyException",
                "El usuario ya existe en la base de datos");
    }
}