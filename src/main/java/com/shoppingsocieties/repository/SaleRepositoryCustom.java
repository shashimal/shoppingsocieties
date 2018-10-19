package com.shoppingsocieties.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * Custom SaleRepository for supporting native and custom queries
 *
 */
public interface SaleRepositoryCustom {

    /***
     * Get the current flash sales by country
     *
     * @param country
     * @param currentTime
     * @return
     */
    List<Object[]> getCurrentFlashSalesByCountry(String country,Date currentTime);

}
