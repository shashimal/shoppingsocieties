package com.shoppingsocieties.repository;

import com.shoppingsocieties.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Responsible for handling all the database operations of Sale entity
 *
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> ,SaleRepositoryCustom{
}
