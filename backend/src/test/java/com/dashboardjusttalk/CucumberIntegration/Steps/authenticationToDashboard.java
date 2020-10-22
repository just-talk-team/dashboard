package com.dashboardjusttalk.CucumberIntegration.Steps;

import com.dashboardjusttalk.CucumberIntegration.SpringIntegrationTest;
import com.dashboardjusttalk.Dto.UserLoginDto;
import com.dashboardjusttalk.controller.UserController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class authenticationToDashboard extends SpringIntegrationTest {
    @Autowired
    private UserController userController;
    private ResponseEntity responseEntity;

    @When("introduce {string} and {string}")
    public void introduceAnd(String arg0, String arg1) {
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setPassword(arg1);
        userLoginDto.setUser(arg0);
        responseEntity= userController.ValidateLogin(userLoginDto);
    }

    @Then("receives status code of {int}")
    public void receivesStatusCodeOf(int arg0) {
        assertEquals(arg0,responseEntity.getStatusCodeValue());
    }

}

