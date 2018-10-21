package com.shoppingsocieties.integration.controller;

import com.shoppingsocieties.controller.WalletController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WalletControllerIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    WalletController walletController;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.walletController).build();
    }

    @Test
    public void testFindWalletById() throws Exception {
        mockMvc.perform(get("/wallet/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("currency", is("SGD")));

        mockMvc.perform(get("/wallet/4").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(4)))
                .andExpect(jsonPath("currency", is("SGD")))
                .andExpect(jsonPath("balance", is(00.00)));
    }

}
