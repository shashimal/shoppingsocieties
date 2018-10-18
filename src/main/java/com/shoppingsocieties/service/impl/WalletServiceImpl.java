package com.shoppingsocieties.service.impl;

import com.shoppingsocieties.common.StringConstant;
import com.shoppingsocieties.entity.Wallet;
import com.shoppingsocieties.exception.InvalidIdException;
import com.shoppingsocieties.repository.WalletRepository;
import com.shoppingsocieties.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/***
 *
 * Implementation for WalletService functions
 *
 */
@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    /***
     * Implementation for findWalletById
     *
     * @param walletId
     * @return wallet object
     */
    @Override
    public Wallet findWalletById(Long walletId) throws Exception {
        Optional<Wallet> wallet = walletRepository.findById(walletId);

        if (walletId == null) {
            throw new InvalidIdException(StringConstant.INVALID_ID);
        }

        if (!wallet.isPresent()) {
            throw new EntityNotFoundException(StringConstant.ENTITY_NOT_FOUND);
        }

        return wallet.get();
    }

}
