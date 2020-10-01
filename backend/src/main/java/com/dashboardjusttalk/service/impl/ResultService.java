package com.dashboardjusttalk.service.impl;

import com.dashboardjusttalk.repository.ResultRepository;
import com.dashboardjusttalk.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService implements IResultService {
    @Autowired
    ResultRepository resultRepository;

}
