package com.dashboardjusttalk.CucumberIntegration.Steps;

import com.dashboardjusttalk.Dto.UserRegistrationDto;
import com.dashboardjusttalk.controller.UserController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

public class registrationToDashboard {

    @Autowired
    private UserController userController;
    private ResponseEntity responseEntity;
    @When("introduce {string}, {string}, {string}")
    public void introduce(String user, String name, String password) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setUser(user);
        userRegistrationDto.setName(name);
        userRegistrationDto.setPassword(password);
        responseEntity = userController.Registration(userRegistrationDto);
    }
    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        assertEquals(arg0,responseEntity.getStatusCodeValue());
    }
}
