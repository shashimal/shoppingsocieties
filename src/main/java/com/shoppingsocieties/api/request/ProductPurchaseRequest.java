package com.shoppingsocieties.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPurchaseRequest extends RestRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("purchased_quantity")
    private  Integer purchasedQuantity;
}
