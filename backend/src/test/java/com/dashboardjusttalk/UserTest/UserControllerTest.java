//package com.dashboardjusttalk.UserTest;
//
//import com.dashboardjusttalk.Abstract.AbstractTest;
//import com.dashboardjusttalk.Dto.ResultInsertionDto;
//import com.dashboardjusttalk.Dto.UserAccessDto;
//import com.dashboardjusttalk.Dto.UserLoginDto;
//import com.dashboardjusttalk.Dto.UserRegistrationDto;
//import com.dashboardjusttalk.Exception.UserIncorrectPasswordException;
//import com.dashboardjusttalk.Exception.UserLoginNotFoundException;
//import com.dashboardjusttalk.controller.UserController;
//import com.dashboardjusttalk.service.IUserService;
//import com.dashboardjusttalk.service.impl.UserService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Date;
//
//import static org.junit.Assert.assertEquals;
//
//public class UserControllerTest extends AbstractTest {
//    private UserController userController;
//    private UserService userService;
//    @Before
//    public void Setup(){
//        userService = Mockito.mock(UserService.class);
//        userController = new UserController();
//        super.setUp();}
//
//    @Test
//    public void itShouldReturnOkStatus() throws UserLoginNotFoundException, UserIncorrectPasswordException {
//        UserLoginDto userLoginDto = new UserLoginDto();
//        userLoginDto.setUser("mockito");
//        userLoginDto.setPassword("1234567");
//
//        UserAccessDto userAccessDto = new UserAccessDto();
//        userAccessDto.setUser("mockito");
//        userAccessDto.setName("mocki");
//        userAccessDto.setId(5);
//        Mockito.when(userService.DashboardAccess("mockito","1234567")).thenReturn(userAccessDto);
//        ResponseEntity <?> httpResponse = userController.ValidateLogin(userLoginDto);
//
//        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);
//        Assert.assertEquals(userAccessDto,httpResponse.getBody());
//    }
//    @Test
//    public void CreateANewUser() throws Exception{
//        String uri ="http://localhost:9090/dashboard/api/user/signup";
//        UserRegistrationDto userRegistrationDto=new UserRegistrationDto();
//        userRegistrationDto.setName("mocki");
//        userRegistrationDto.setPassword("1234567");
//        userRegistrationDto.setUser("mockito");
//        String inputJson = super.mapToJson(userRegistrationDto);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals((int)200,status);
//    }
//    @Test
//    public void LoginIntoAccount() throws Exception{
//
//        String uri = "http://localhost:9090/dashboard/api/user/login";
//        UserLoginDto userLoginDto = new UserLoginDto();
//        userLoginDto.setUser("mockito");
//        userLoginDto.setPassword("1234567");
//        UserAccessDto test = new UserAccessDto();
//        test.setId(6);
//        test.setName("pruebas root");
//        test.setUser("root");
//
//        String inputJson = super.mapToJson(userLoginDto);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals((int)400,status);
///*       String content = mvcResult.getResponse().getContentAsString();
//        UserAccessDto userAccessDto = super.mapFromJson(content,UserAccessDto.class);
//        assertEquals(userAccessDto,test);*/
//    }
//
//}
