package com.shoppingsocieties.integration.service;

import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;
import com.shoppingsocieties.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testPurchase() throws Exception {
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(1).userId(2L).build();
        ProductPurchaseResponse productPurchaseResponse = productService.purchase(1L, productPurchaseRequest);
        assertEquals(new Long(1),productPurchaseResponse.getSalesId());
        assertEquals(new Long(2),productPurchaseResponse.getProductPurchaseRequest().getUserId());
        assertEquals(new Integer(1),productPurchaseResponse.getProductPurchaseRequest().getPurchasedQuantity());
        assertEquals("Duleendra Shashimal",productPurchaseResponse.getUserWallet().getUser().getName());
    }

}
