package com.shoppingsocieties.repository;

import com.shoppingsocieties.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Responsible for handling all the database operations of Wallet entity
 *
 */
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

}
