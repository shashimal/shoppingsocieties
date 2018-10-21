package com.shoppingsocieties.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.controller.ProductController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ProductController productController;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(this.productController).build();
    }

    @Test
    public void testPurchase() throws Exception {
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .userId(2L)
                .purchasedQuantity(1)
                .build();

        mockMvc.perform(post("/products/7/purchase").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productPurchaseRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("sales_id", is(7)))
                .andExpect(jsonPath("$.purchase_request.user_id", is(2)))
                .andExpect(jsonPath("$.purchase_request.purchased_quantity", is(1)))
                .andExpect(jsonPath("$.user_wallet.id", is(2)))
                .andExpect(jsonPath("$.user_wallet.currency", is("SGD")));
    }
}
