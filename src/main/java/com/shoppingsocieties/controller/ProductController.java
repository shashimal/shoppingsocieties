package com.shoppingsocieties.controller;

import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;
import com.shoppingsocieties.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * Rest endpoints for handling product related functions
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /***
     * Purchase a flash sale item
     *
     * @param salesId
     * @return ProductPurchaseResponse details
     */
    @PostMapping("/{salesId}/purchase")
    public ResponseEntity<ProductPurchaseResponse> purchase(@PathVariable(value = "salesId") Long salesId, @RequestBody ProductPurchaseRequest productPurchaseRequest) throws Exception {
        ProductPurchaseResponse productPurchaseResponse = productService.purchase(salesId, productPurchaseRequest);
        return new ResponseEntity<>(productPurchaseResponse,HttpStatus.OK);
    }
}
