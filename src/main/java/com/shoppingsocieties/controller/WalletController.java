package com.shoppingsocieties.controller;

import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * Rest endpoints for handling wallet related functions
 *
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    /***
     * Find wallet information by wallet it
     *
     * @param walletId
     * @return wallet information
     * @throws Exception
     */
    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet> findWalletById(@PathVariable(value = "walletId") Long walletId) throws Exception {
        Wallet wallet = walletService.findWalletById(walletId);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }
}
