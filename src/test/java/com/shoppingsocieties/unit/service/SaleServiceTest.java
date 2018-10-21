package com.shoppingsocieties.unit.service;

import com.shoppingsocieties.api.response.SaleResponse;
import com.shoppingsocieties.common.StringConstant;
import com.shoppingsocieties.repository.SaleRepository;
import com.shoppingsocieties.service.impl.SaleServiceImpl;
import com.shoppingsocieties.util.DateUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class SaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleServiceImpl saleService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testGetCurrentFlashSalesByCountry() throws Exception {
        //given
        Date currentTime = DateUtil.getCurrentTime();
        Object[] object1 = new Object[]{BigInteger.valueOf(1), 900.50, "SGD", 20, 20, "SG", DateUtil.getDateFromString("2018-10-20 00:00:00"), DateUtil.getDateFromString("2018-10-22 00:00:00")};
        List<Object[]> list = new ArrayList<>();
        list.add(object1);

        //when
        when(saleRepository.getCurrentFlashSalesByCountry("SGD", currentTime)).thenReturn(list);
        SaleResponse result = saleService.getCurrentFlashSalesByCountry("SGD");

        //then
        assertEquals(1, result.getSales().size());
        assertEquals(new Long(1), result.getSales().get(0).getProductId());
        assertEquals(new Double(900.50), result.getSales().get(0).getPrice());
        assertEquals(new Integer(20), result.getSales().get(0).getTotalItems());
        assertEquals(new Integer(20), result.getSales().get(0).getItemsLeft());

        verify(saleRepository).getCurrentFlashSalesByCountry("SGD", currentTime);
        verify(saleRepository, times(1)).getCurrentFlashSalesByCountry("SGD", currentTime);
    }

    @Test
    public void testNoFlashSalesException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(StringConstant.NO_FLASH_SALES);
        saleService.getCurrentFlashSalesByCountry("DKG");
    }
}
