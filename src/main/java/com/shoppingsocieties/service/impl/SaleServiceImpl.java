package com.shoppingsocieties.service.impl;

import com.shoppingsocieties.api.SaleResponse;
import com.shoppingsocieties.common.StringConstant;
import com.shoppingsocieties.dto.SalesDTO;
import com.shoppingsocieties.exception.NoSalesException;
import com.shoppingsocieties.repository.SaleRepository;
import com.shoppingsocieties.service.SaleService;
import com.shoppingsocieties.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Implementation for salve service functions
 *
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    /***
     * Get current flash sales by country
     *
     * @param country
     * @return SaleResponse object
     * @throws Exception
     */
    @Override
    public SaleResponse getCurrentFlashSalesByCountry(String country) throws Exception {
        Date currentTime = DateUtil.getCurrentTime();

        List<Object[]> sales = saleRepository.getCurrentFlashSalesByCountry(country, currentTime);

        if (sales != null && sales.size() == 0) {
            throw new NoSalesException(StringConstant.NO_FLASH_SALES);
        }

        List<SalesDTO> saleDTOS = new ArrayList<>();

        sales.stream().forEach((record) -> saleDTOS.add(SalesDTO.builder().
                productId(((BigInteger) record[0]).longValue()).price((Double) record[1])
                .currency((String) record[2])
                .totalItems((Integer) record[3])
                .itemsLeft((Integer) record[4])
                .timeLeft(DateUtil.getTimeDifference(currentTime, (Date) record[7]))
                .build()));

        return SaleResponse.builder().sales(saleDTOS).build();
    }
}
