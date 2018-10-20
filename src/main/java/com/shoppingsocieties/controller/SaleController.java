package com.shoppingsocieties.controller;

import com.shoppingsocieties.api.response.SaleResponse;
import com.shoppingsocieties.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * Rest endpoints for handling wallet sales related functions
 *
 */

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @GetMapping("/current")
    public ResponseEntity<SaleResponse> getCurrentFlashSales( @RequestParam("country") String country) throws Exception {
        SaleResponse sales = saleService.getCurrentFlashSalesByCountry(country);
        return new ResponseEntity<>(sales, HttpStatus.OK);

    }

}