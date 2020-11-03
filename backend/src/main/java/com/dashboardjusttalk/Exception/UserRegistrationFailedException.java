package com.dashboardjusttalk.Exception;

import com.dashboardjusttalk.Dto.ExceptionDto;

public class UserRegistrationFailedException extends Exception{
    public ExceptionDto exceptionDto;

    public UserRegistrationFailedException() {
        exceptionDto = new ExceptionDto("UserRegistrationFailedException",
                "Hubo un error en el registro");
    }
}
