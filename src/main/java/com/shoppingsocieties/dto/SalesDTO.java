package com.shoppingsocieties.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SalesDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("total_items")
    private Integer totalItems;

    @JsonProperty("items_left")
    private Integer itemsLeft;

    @JsonProperty("time_left")
    private Long timeLeft;
}
