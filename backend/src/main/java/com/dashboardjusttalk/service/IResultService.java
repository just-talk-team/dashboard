package com.dashboardjusttalk.service;

import com.dashboardjusttalk.Dto.IResultResponseDto;
import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Dto.ResultSearchDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;

import java.util.Collection;

public interface IResultService {
     boolean InsertResult(ResultInsertionDto resultInsertionDto)throws ResultInsertionFailedException;
    Collection<IResultResponseDto> GetResultsResponse(ResultSearchDto resultSearchDto);
}
