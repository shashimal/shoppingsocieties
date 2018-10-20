package com.shoppingsocieties.service;

import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;

/***
 * ProductService is responsible for handling product related functions
 *
 */
public interface ProductService {

    /***
     * Purchase a flash sale item
     *
     * @param salesId
     * @param productPurchaseRequest
     * @return ProductPurchaseResponse
     * @throws Exception
     */
    ProductPurchaseResponse purchase(Long salesId, ProductPurchaseRequest productPurchaseRequest) throws Exception;
}
