package com.dashboardjusttalk.Exception;

import com.dashboardjusttalk.Dto.ExceptionDto;

public class ResultInsertionFailedException extends Exception {
    public ExceptionDto exceptionDto;

    public ResultInsertionFailedException() {
        exceptionDto = new ExceptionDto("ResultInsertionFailedException",
                "Ocurrió un error al guardar el resultado");
    }
}