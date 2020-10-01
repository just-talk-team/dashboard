package com.dashboardjusttalk.controller;

import com.dashboardjusttalk.service.IResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard/api")
@RequiredArgsConstructor
public class ResultController {
    @Autowired
    private IResultService resultService;
}
