package com.dashboardjusttalk.controller;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Dto.ResultSearchDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;
import com.dashboardjusttalk.service.IResultService;
import com.dashboardjusttalk.service.impl.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/api")
@RequiredArgsConstructor
public class ResultController {
    @Autowired
    private IResultService resultService;

    @PostMapping("result")
    public ResponseEntity<?> CreateEntryResult(@RequestBody ResultInsertionDto resultInsertionDto){
        try {
            resultService.InsertResult(resultInsertionDto);
            return ResponseEntity.status(201).build();
        }catch (ResultInsertionFailedException exception){
            return ResponseEntity.status(400).body(exception.exceptionDto);
        }

    }
    @PostMapping("result/search")
    public ResponseEntity<?> ReadResultsMatched(@RequestBody ResultSearchDto resultSearchDto){

        return ResponseEntity.status(200).body(resultService.GetResultsResponse(resultSearchDto));

    }
}
