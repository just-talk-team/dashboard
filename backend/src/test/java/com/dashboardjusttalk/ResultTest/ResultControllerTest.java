package com.dashboardjusttalk.ResultTest;

import com.dashboardjusttalk.Abstract.AbstractTest;
import com.dashboardjusttalk.Dto.ResultInsertionDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ResultControllerTest extends AbstractTest {

    @Before
    public void Setup(){super.setUp();}

    @Test
    public void CreateResult() throws Exception{
        String uri = "http://localhost:9090/dashboard/api/result";
        Date birthdate =new Date();
        birthdate.setYear(1996);
        birthdate.setMonth(12);
        birthdate.setDate(11);
        Date startTime =new Date();
        startTime.setYear(1996);
        startTime.setMonth(12);
        startTime.setDate(11);
        startTime.setHours(12);
        startTime.setMinutes(20);
        Date endTime =new Date();
        endTime.setYear(1996);
        endTime.setMonth(12);
        endTime.setDate(11);
        endTime.setHours(12);
        endTime.setMinutes(25);
        ResultInsertionDto resultInsertionDto = new ResultInsertionDto();
        resultInsertionDto.setBadgesAwarded("divertido");
        resultInsertionDto.setBirthdate(birthdate);
        resultInsertionDto.setBirthdateQualifiedUser(birthdate);
        resultInsertionDto.setEndTime(endTime);
        resultInsertionDto.setGender("woman");
        resultInsertionDto.setGenderQualifiedUser("woman");
        resultInsertionDto.setSegments("upc.edu.pe");
        resultInsertionDto.setSegmentsQualifiedUser("upc.edu.pe");
        resultInsertionDto.setStartTime(startTime);
        resultInsertionDto.setTopicsHear("viajes a cuzco");
        resultInsertionDto.setTopicsHearQualifiedUser("viajes a cuzco");
        resultInsertionDto.setTopicsTalk("COVID,Clasicas de cachimbos");
        resultInsertionDto.setTopicsTalkQualifiedUser("COVID,Clasicas de cachimbos");
        resultInsertionDto.setUserType("premium");
        resultInsertionDto.setUserTypeQualifiedUser("premium");

        String inputJson = super.mapToJson(resultInsertionDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201,status);
    }
}
