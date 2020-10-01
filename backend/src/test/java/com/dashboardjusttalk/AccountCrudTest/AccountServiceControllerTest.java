package com.dashboardjusttalk.AccountCrudTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AccountServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Obtener la lista de todas las cuentas
    /*@Test
    public void getAccountsList() throws Exception {
        String uri = "http://localhost:9191/dashboard/api/accounts";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Account[] accountlist = super.mapFromJson(content, Account[].class);
        assertTrue(accountlist.length > 0);
    }

    //Crear una cuenta test
    @Test
    public void createAccount() throws Exception {
        String uri = "http://localhost:9191/dashboard/api/accounts";
        Account account = new Account();
        account.setId(10);
        account.setFirstname("Viviana");
        account.setLastname("Angeles");
        account.setEmail("angelesviviana@gmail.com");
        
        String inputJson = super.mapToJson(account);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Actualiza-Modifica el nombre del id #11
    @Test
    public void updateAccount() throws Exception {
        String uri = "http://localhost:9191/dashboard/api/accounts/11";
        Account account = new Account();
        account.setId(11);
        account.setFirstname("Paola");
        account.setLastname("Angeles");

        String inputJson = super.mapToJson(account);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Borra la cuenta que tiene el id #12
    @Test
    public void deleteAccount() throws Exception {
        String uri = "http://localhost:9191/dashboard/api/accounts/12";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }*/

}
