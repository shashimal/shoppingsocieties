package com.shoppingsocieties.integration.service;


import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.service.WalletService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletServiceIntegrationTest {

    @Autowired
    private WalletService walletService;

    @Test
    public void testFindWalletById() throws Exception {
        Wallet wallet = walletService.findWalletById(1L);
        assertEquals(new Long(1), wallet.getId());
        assertEquals("SGD", wallet.getCurrency());
        assertEquals("Shopping Societies", wallet.getUser().getName());
    }
}
