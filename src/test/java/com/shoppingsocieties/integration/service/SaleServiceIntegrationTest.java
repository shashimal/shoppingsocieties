package com.shoppingsocieties.integration.service;

import com.shoppingsocieties.api.response.SaleResponse;
import com.shoppingsocieties.service.SaleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceIntegrationTest {

    @Autowired
    private SaleService saleService;

    @Test
    public void testGetCurrentFlashSalesByCountry() throws Exception {
        SaleResponse saleResponse = saleService.getCurrentFlashSalesByCountry("SG");
        saleResponse.getSales().forEach(sale->{
            assertEquals("SGD",sale.getCurrency());
        });

    }
}
