package com.shoppingsocieties.service;

import com.shoppingsocieties.entity.Wallet;

/***
 * WalletService is responsible for handling Wallet related functions
 *
 */
public interface WalletService {

    /***
     * Find a wallet by its id
     *
     * @param walletId
     * @return wallet object
     */
    Wallet findWalletById(Long walletId) throws Exception;

}
