package com.shoppingsocieties.repository;

import com.shoppingsocieties.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Responsible for handling all the database operations of product entity
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
