package com.dashboardjusttalk.CucumberIntegration.Steps;

import com.dashboardjusttalk.CucumberIntegration.SpringIntegrationTest;
import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.controller.ResultController;
import com.dashboardjusttalk.controller.UserController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RegistrationOfResults extends SpringIntegrationTest {

    @Autowired
    private ResultController resultController;
    private ResponseEntity responseEntity;
    @When("introduce a new registry of a talkchat")
    public void introduceANewRegistryOfATalkchat() {
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
        resultInsertionDto.setBadges_awarded(Collections.singleton("gracioso"));
        resultInsertionDto.setBirthdate(birthdate);
        resultInsertionDto.setBirthdate_qualified_user(birthdate);
        resultInsertionDto.setEnd_time(endTime);
        resultInsertionDto.setGender("woman");
        resultInsertionDto.setGender_qualified_user("woman");
        resultInsertionDto.setSegments(Collections.singleton("upc.edu.pe"));
        resultInsertionDto.setSegments_qualified_user(Collections.singleton("upc.edu.pe"));
        resultInsertionDto.setStart_time(startTime);
        resultInsertionDto.setTopics_hear(Collections.singleton("viajes a cuzco"));
        resultInsertionDto.setTopics_hear_qualified_user(Collections.singleton("viajes a cuzco"));
        resultInsertionDto.setTopics_talk(Collections.singleton("COVID,Clasicas de cachimbos"));
        resultInsertionDto.setTopics__talk_qualified_user(Collections.singleton("COVID,Clasicas de cachimbos"));
        resultInsertionDto.setUser_type("premium");
        resultInsertionDto.setUser_type_qualified_user("premium");
        responseEntity= resultController.CreateEntryResult(resultInsertionDto);
    }

    @Then("receives status code {int}")
    public void receivesStatusCodeOfStatus(int arg0){
        assertEquals(arg0,responseEntity.getStatusCodeValue());
    }
}
