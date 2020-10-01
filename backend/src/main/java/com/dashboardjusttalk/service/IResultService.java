package com.dashboardjusttalk.service;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;

public interface IResultService {
    boolean InsertResult(ResultInsertionDto resultInsertionDto)throws ResultInsertionFailedException;
}
