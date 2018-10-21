package com.shoppingsocieties.service;

import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;
import com.shoppingsocieties.entity.Product;
import com.shoppingsocieties.entity.Sale;
import com.shoppingsocieties.entity.User;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.exception.BadRequestException;
import com.shoppingsocieties.exception.ProductPurchaseException;
import com.shoppingsocieties.repository.ProductRepository;
import com.shoppingsocieties.repository.SaleRepository;
import com.shoppingsocieties.repository.UserRepository;
import com.shoppingsocieties.service.impl.ProductServiceImpl;
import com.shoppingsocieties.util.DateUtil;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testPurchase() throws Exception {
        //given
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(1).userId(2L).build();

        Sale sale = new Sale(1L, 1L, 550.00, 50, 40,
                DateUtil.getDateFromString("2018-10-20 00:00:00"),
                DateUtil.getDateFromString("2018-10-21 00:00:00"), null);

        User user = User.builder()
                .id(2L)
                .name("Duleendra Shashimal")
                .wallet(Wallet.builder().id(2L).balance(5000.00).currency("SGD").build())
                .build();

        User company = User.builder()
                .id(1L)
                .name("Shopping Societies")
                .wallet(Wallet.builder().id(1L).balance(1000.00).currency("SGD").build())
                .build();

        Product product = Product.builder()
                .id(1L)
                .name("Apple Watch")
                .unitPrice(550.00)
                .unitsInStock(60)
                .build();

        //when
        when(saleRepository.findById(1L)).thenReturn(Optional.of(sale));
        when(userRepository.findById(productPurchaseRequest.getUserId())).thenReturn(Optional.of(user));
        when(productRepository.findById(sale.getProductId())).thenReturn(Optional.of(product));
        when(userRepository.findById(1L)).thenReturn(Optional.of(company));

        ProductPurchaseResponse result = productService.purchase(1L, productPurchaseRequest);

        //then
        assertEquals(new Long(2), result.getUserWallet().getId());
        assertEquals(new Double(4450.00), result.getUserWallet().getBalance());
    }

    @Test
    public void testInvalidSalesIdException() throws Exception {
        //given
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(1).userId(2L).build();

        //then
        exceptionRule.expect(ProductPurchaseException.class);
        exceptionRule.expectMessage("Invalid product purchase request");
        productService.purchase(1000L, productPurchaseRequest);
    }

    @Test
    public void testUserDoesNotHaveWalletException() throws Exception {
        //given
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(1).userId(2L).build();

        Sale sale = new Sale(2L, 1L, 550.00, 50, 40, DateUtil.getDateFromString("2018-10-20 00:00:00"),
                DateUtil.getDateFromString("2018-10-21 00:00:00"), null);

        User user = User.builder()
                .id(2L)
                .name("Shasimal")
                .wallet(null)
                .build();

        //when
        when(saleRepository.findById(2L)).thenReturn(Optional.of(sale));
        when(userRepository.findById(productPurchaseRequest.getUserId())).thenReturn(Optional.of(user));

        //then
        exceptionRule.expect(BadRequestException.class);
        exceptionRule.expectMessage("User does not have a wallet to complete this transaction");
        productService.purchase(2L, productPurchaseRequest);
    }

    @Test
    public void testInvalidWalletIdException() throws Exception {
        //given
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(1).userId(2L).build();

        Sale sale = new Sale(2L, 1L, 550.00, 50, 40, DateUtil.getDateFromString("2018-10-20 00:00:00"),
                DateUtil.getDateFromString("2018-10-21 00:00:00"), null);

        User user = User.builder()
                .id(1L)
                .name("Shopping Societies")
                .wallet(Wallet.builder().id(1L).balance(1000.00).currency("SGD").build())
                .build();

        //when
        when(saleRepository.findById(2L)).thenReturn(Optional.of(sale));
        when(userRepository.findById(productPurchaseRequest.getUserId())).thenReturn(Optional.of(user));

        //then
        exceptionRule.expect(BadRequestException.class);
        exceptionRule.expectMessage("Invalid wallet id");
        productService.purchase(2L, productPurchaseRequest);
    }

    @Test
    public void testInsufficientWalletBalanceException() throws Exception {
        //given
        ProductPurchaseRequest productPurchaseRequest = ProductPurchaseRequest.builder()
                .purchasedQuantity(4).userId(2L).build();

        Sale sale = new Sale(2L, 1L, 550.00, 50, 40, DateUtil.getDateFromString("2018-10-20 00:00:00"),
                DateUtil.getDateFromString("2018-10-21 00:00:00"), null);

        User user = User.builder()
                .id(1L)
                .name("Shopping Societies")
                .wallet(Wallet.builder().id(2L).balance(100.00).currency("SGD").build())
                .build();

        //when
        when(saleRepository.findById(2L)).thenReturn(Optional.of(sale));
        when(userRepository.findById(productPurchaseRequest.getUserId())).thenReturn(Optional.of(user));

        //then
        exceptionRule.expect(BadRequestException.class);
        exceptionRule.expectMessage("Insufficient wallet balance");
        productService.purchase(2L, productPurchaseRequest);
    }
}
