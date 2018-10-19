package com.shoppingsocieties.service;

import com.shoppingsocieties.api.SaleResponse;

/***
 * SaleService is responsible for handling sales related functions
 *
 */
public interface SaleService {

    /***
     * Get current flash sales by country
     *
     * @param country
     * @return SaleResponse object
     * @throws Exception
     */
    SaleResponse getCurrentFlashSalesByCountry(String country) throws Exception;
}
