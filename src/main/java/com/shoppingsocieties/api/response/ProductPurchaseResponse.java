package com.shoppingsocieties.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductPurchaseResponse {

    @JsonProperty("sales_id")
    private Long salesId;

    @JsonProperty("user_wallet")
    private Wallet userWallet;

    @JsonProperty("purchase_request")
    private ProductPurchaseRequest productPurchaseRequest;


}
