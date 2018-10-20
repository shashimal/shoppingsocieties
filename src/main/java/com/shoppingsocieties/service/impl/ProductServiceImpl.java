package com.shoppingsocieties.service.impl;

import com.shoppingsocieties.api.request.ProductPurchaseRequest;
import com.shoppingsocieties.api.response.ProductPurchaseResponse;
import com.shoppingsocieties.entity.Product;
import com.shoppingsocieties.entity.Sale;
import com.shoppingsocieties.entity.User;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.exception.ProductPurchaseException;
import com.shoppingsocieties.exception.BadRequestException;
import com.shoppingsocieties.repository.ProductRepository;
import com.shoppingsocieties.repository.SaleRepository;
import com.shoppingsocieties.repository.UserRepository;
import com.shoppingsocieties.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/***
 * Implementation for product service functions
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;

    /***
     * Purchase a flash sale item
     *
     * @param salesId
     * @param productPurchaseRequest
     * @return ProductPurchaseResponse
     * @throws Exception
     */
    @Transactional
    @Override
    public ProductPurchaseResponse purchase(Long salesId, ProductPurchaseRequest productPurchaseRequest) throws Exception {
        //Get the purchased flash sale details
        Sale sale = saleRepository.findById(salesId).get();
        //Validate the the flash sale object
        this.validateSale(sale);

        //Get the user details who purchased this item
        User user = userRepository.findById(productPurchaseRequest.getUserId()).get();
        Wallet userWallet = user.getWallet();

        //Total price of purchased items
        Double totalPrice = sale.getPrice() * productPurchaseRequest.getPurchasedQuantity();

        //Validate the user's wallet before proceeding to complete the transaction
        this.validateUserWallet(userWallet, totalPrice);

        //If the user has a valid wallet and sufficient fund
        //following actions need to be completed

        //Update the flash sale stock
        sale.setItemsLeft(sale.getItemsLeft() - productPurchaseRequest.getPurchasedQuantity());
        saleRepository.save(sale);

        //Update the main stock of purchased product
        Product product = productRepository.findById(sale.getProductId()).get();
        product.setUnitsInStock(product.getUnitsInStock() - productPurchaseRequest.getPurchasedQuantity());
        productRepository.save(product);

        //Update the user wallet
        userWallet.setBalance(userWallet.getBalance() - totalPrice);
        user.setWallet(userWallet);
        userRepository.save(user);

        //Update the company wallet
        User company = userRepository.findById(1L).get();
        Wallet companyWallet = company.getWallet();
        companyWallet.setBalance(companyWallet.getBalance() + totalPrice);
        userRepository.save(company);

        // TODO: 10/20/18
        //Update order and order details

        return ProductPurchaseResponse.builder().salesId(salesId)
                .productPurchaseRequest(productPurchaseRequest)
                .userWallet(userWallet)
                .build();
    }

    /**
     * Validate user's wallet
     *
     * @param userWallet
     * @param totalPrice
     * @throws Exception
     */
    private void validateUserWallet(Wallet userWallet, Double totalPrice) throws Exception {
        if (userWallet == null) {
            throw new BadRequestException("User does not have a wallet to complete this transaction");
        }

        if (userWallet.getId() == 1) {
            throw new BadRequestException("Invalid wallet id");
        }

        if (userWallet.getBalance() < totalPrice) {
            throw new BadRequestException("Insufficient wallet balance");
        }
    }

    /**
     * Validate sale details
     *
     * @param sale
     * @throws ProductPurchaseException
     */
    private void validateSale(Sale sale) throws ProductPurchaseException {
        if (sale == null) {
            throw new ProductPurchaseException("Invalid product purchase request");
        }
    }
}
