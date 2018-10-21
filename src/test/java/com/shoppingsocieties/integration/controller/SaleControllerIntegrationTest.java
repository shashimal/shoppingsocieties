package com.shoppingsocieties.integration.controller;

import com.shoppingsocieties.controller.SaleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleControllerIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    SaleController saleController;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.saleController).build();
    }

    @Test
    public void getCurrentFlashSales() throws Exception {
        mockMvc.perform(get("/sales/current?country=SG").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sales[0].product_id", is(1)))
                .andExpect(jsonPath("$.sales[0].price", is(950.00)))
                .andExpect(jsonPath("$.sales[0].total_items", is(5)))
                .andExpect(jsonPath("$.sales[0].total_items", is(5)))
                .andExpect(jsonPath("$.sales[1].product_id", is(2)))
                .andExpect(jsonPath("$.sales[1].price", is(750.00)))
                .andExpect(jsonPath("$.sales[1].total_items", is(10)));

    }

}
