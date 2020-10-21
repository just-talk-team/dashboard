package com.dashboardjusttalk.service.impl;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Dto.ResultResponseDto;
import com.dashboardjusttalk.Dto.ResultSearchDto;
import com.dashboardjusttalk.Dto.converter.ResultInsertionDtoConverter;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;
import com.dashboardjusttalk.model.Result;
import com.dashboardjusttalk.repository.ResultRepository;
import com.dashboardjusttalk.service.IResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService implements IResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private ResultInsertionDtoConverter resultInsertionDtoConverter = new ResultInsertionDtoConverter();
    @Override
    public boolean InsertResult(ResultInsertionDto resultInsertionDto) throws ResultInsertionFailedException{
        try{
            Result newEntry = resultInsertionDtoConverter.convertToEntity(resultInsertionDto);
            resultRepository.save(newEntry);
            return true;
        }catch(Exception exception){
            throw new ResultInsertionFailedException();
        }
    }
//
//    public List<ResultResponseDto> GetResultsResponse(ResultSearchDto resultSearchDto){
//
//    }
}
