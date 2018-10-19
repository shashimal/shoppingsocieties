package com.shoppingsocieties.api;

import com.shoppingsocieties.dto.SalesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse {

    List<SalesDTO> sales;
}
