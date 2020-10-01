package com.dashboardjusttalk.service.impl;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;
import com.dashboardjusttalk.model.Result;
import com.dashboardjusttalk.repository.ResultRepository;
import com.dashboardjusttalk.service.IResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements IResultService {
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public boolean InsertResult(ResultInsertionDto resultInsertionDto) throws ResultInsertionFailedException{
        try{
            Result newEntry = modelMapper.map(resultInsertionDto, Result.class);
            resultRepository.save(newEntry);
            return true;
        }catch(Exception exception){
            throw new ResultInsertionFailedException();
        }
    }
}
