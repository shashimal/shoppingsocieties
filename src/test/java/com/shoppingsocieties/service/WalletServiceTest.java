package com.shoppingsocieties.service;

import com.shoppingsocieties.entity.User;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.repository.WalletRepository;
import com.shoppingsocieties.service.impl.WalletServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletServiceImpl walletService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindWalletById() throws Exception {
        //given
        Wallet wallet = new Wallet(1L, 500.00, "SGD", null);

        //when
        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));
        Wallet resultWallet = walletService.findWalletById(1L);

        //then
        assertEquals(new Long(1), resultWallet.getId());
        assertEquals("SGD", resultWallet.getCurrency());
        assertEquals(new Double(500.00), resultWallet.getBalance());

        verify(walletRepository).findById(1L);
        verify(walletRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindWalletByIdWithUser() throws Exception {
        //given
        User user = User.builder().id(1L).name("Shopping Societies").build();

        Wallet wallet = Wallet.builder().id(1L).currency("SGD").balance(500.00).user(user).build();

        //when
        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));
        Wallet resultWallet = walletService.findWalletById(1L);

        //then
        assertEquals(new Long(1), resultWallet.getId());
        assertEquals("SGD", resultWallet.getCurrency());
        assertEquals(new Double(500.00), resultWallet.getBalance());
        assertEquals(new Long(1), resultWallet.getUser().getId());
        assertEquals("Shopping Societies", resultWallet.getUser().getName());

    }
}
