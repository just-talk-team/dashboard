package com.dashboardjusttalk.controller;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Exception.ResultInsertionFailedException;
import com.dashboardjusttalk.service.IResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
