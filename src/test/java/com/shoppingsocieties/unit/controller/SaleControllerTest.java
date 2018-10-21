package com.shoppingsocieties.unit.controller;

import com.shoppingsocieties.api.response.SaleResponse;
import com.shoppingsocieties.controller.SaleController;
import com.shoppingsocieties.dto.SalesDTO;
import com.shoppingsocieties.service.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = SaleController.class, secure = false)
public class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SaleController saleController;

    @MockBean
    private SaleService saleService;

    @Test
    public void testGetCurrentFlashSalesByCountry() throws Exception {
        //given
        List<SalesDTO> salesDTOS = new ArrayList<>();
        salesDTOS.add(SalesDTO.builder().productId(1L)
                .price(950.00).currency("SGD").totalItems(20).itemsLeft(10).timeLeft(1000000L).build());
        salesDTOS.add(SalesDTO.builder().productId(2L)
                .price(150.00).currency("SGD").totalItems(10).itemsLeft(5).timeLeft(2000000L).build());

        SaleResponse saleResponse = SaleResponse.builder().sales(salesDTOS).build();

        //when
        when(saleService.getCurrentFlashSalesByCountry("SG")).thenReturn(saleResponse);

        //then
        mockMvc.perform(get("/sales/current?country=SG").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sales[0].product_id", is(1)))
                .andExpect(jsonPath("$.sales[0].price", is(950.00)))
                .andExpect(jsonPath("$.sales[0].currency", is("SGD")))
                .andExpect(jsonPath("$.sales[0].total_items", is(20)))
                .andExpect(jsonPath("$.sales[0].items_left", is(10)))
                .andExpect(jsonPath("$.sales[0].time_left", is(1000000)))
                .andExpect(jsonPath("$.sales[1].product_id", is(2)))
                .andExpect(jsonPath("$.sales[1].price", is(150.00)))
                .andExpect(jsonPath("$.sales[1].currency", is("SGD")))
                .andExpect(jsonPath("$.sales[1].total_items", is(10)))
                .andExpect(jsonPath("$.sales[1].items_left", is(5)))
                .andExpect(jsonPath("$.sales[1].time_left", is(2000000)));
    }
}
