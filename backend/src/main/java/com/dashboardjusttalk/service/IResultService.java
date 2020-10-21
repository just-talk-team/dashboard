package com.dashboardjusttalk.service;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Dto.ResultResponseDto;
import com.dashboardjusttalk.Dto.ResultSearchDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;

import java.util.List;

public interface IResultService {
     boolean InsertResult(ResultInsertionDto resultInsertionDto)throws ResultInsertionFailedException;
    List<ResultResponseDto> GetResultsResponse(ResultSearchDto resultSearchDto);
}
