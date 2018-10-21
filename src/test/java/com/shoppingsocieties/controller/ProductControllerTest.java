package com.shoppingsocieties.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.service.ProductService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testPurchase() throws Exception {

        //given
        Long salesId = 1L;
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .userId(2L)
                .purchasedQuantity(1)
                .build();

        ProductPurchaseResponse productPurchaseResponse = ProductPurchaseResponse.builder()
                .userWallet(Wallet.builder().id(2L).balance(550.00).currency("SGD").build())
                .productPurchaseRequest(productPurchaseRequest)
                .salesId(salesId)
                .build();

        //when
        when(productService.purchase(1L,productPurchaseRequest)).thenReturn(productPurchaseResponse);

        //then
        mockMvc.perform(post("/products/1/purchase").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productPurchaseRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("sales_id", is(1)))
                .andExpect(jsonPath("$.purchase_request.user_id", is(2)))
                .andExpect(jsonPath("$.purchase_request.purchased_quantity", is(1)))
                .andExpect(jsonPath("$.user_wallet.id", is(2)))
                .andExpect(jsonPath("$.user_wallet.balance", is(550.00)))
                .andExpect(jsonPath("$.user_wallet.currency", is("SGD")));
    }
}
