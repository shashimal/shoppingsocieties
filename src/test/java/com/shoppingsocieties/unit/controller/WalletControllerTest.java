package com.shoppingsocieties.unit.controller;

import com.shoppingsocieties.controller.WalletController;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.service.WalletService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = WalletController.class, secure = false)
public class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WalletController walletController;

    @MockBean
    private WalletService walletService;

    @Test
    public void testFindWalletById() throws Exception {

        //given
        Wallet wallet = new Wallet(1L, 500.00, "SGD", null);

        //when
        when(walletService.findWalletById(1L)).thenReturn(wallet);

        //then
        mockMvc.perform(get("/wallet/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("currency", is("SGD")))
                .andExpect(jsonPath("balance", is(500.00)));
    }
}
