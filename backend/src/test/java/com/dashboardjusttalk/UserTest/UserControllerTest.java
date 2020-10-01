package com.dashboardjusttalk.UserTest;

import com.dashboardjusttalk.Abstract.AbstractTest;
import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.Dto.UserAccessDto;
import com.dashboardjusttalk.Dto.UserLoginDto;
import com.dashboardjusttalk.Dto.UserRegistrationDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserControllerTest extends AbstractTest {
    @Before
    public void Setup(){super.setUp();}

    @Test
    public void LoginIntoAccount() throws Exception{

        String uri = "http://localhost:9090/dashboard/api/user/login";
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setUser("mockito");
        userLoginDto.setPassword("1234567");
/*        UserAccessDto test = new UserAccessDto();
        test.setId(5);
        test.setName("prueba test");
        test.setUser("test");*/

        String inputJson = super.mapToJson(userLoginDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
/*        String content = mvcResult.getResponse().getContentAsString();
        UserAccessDto userAccessDto = super.mapFromJson(content,UserAccessDto.class);
        assertEquals(userAccessDto,test);*/
    }
    @Test
    public void CreateANewUser() throws Exception{
        String uri ="http://localhost:9090/dashboard/api/user/signup";
        UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
        userRegistrationDto.setName("mocki");
        userRegistrationDto.setPassword("1234567");
        userRegistrationDto.setUser("mockito");
        String inputJson = super.mapToJson(userRegistrationDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }
}
