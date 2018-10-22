package com.shoppingsocieties.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 *
 * Implementation for custom sales repository functions
 *
 */

@Repository
@Transactional
public class SaleRepositoryCustomImpl implements SaleRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    /***
     * Get the current flash sales by country
     *
     * @param country
     * @param currentTime
     * @return
     */
    @Override
    public List<Object[]> getCurrentFlashSalesByCountry(String country, Date currentTime) {
        String sql = "SELECT s.product_id,s.price,e.currency_code," +
                "s.total_items,s.items_left,e.country_code,s.start_time,s.end_time,s.id " +
                "FROM sale s INNER JOIN sale_eligible_country e ON s.id = e.sale_id " +
                " WHERE e.country_code=? AND s.items_left > 0 AND (s.start_time <= ? AND  s.end_time >= ? )";

        Query q = em.createNativeQuery(sql);
        q.setParameter(1, country);
        q.setParameter(2, currentTime);
        q.setParameter(3, currentTime);

        List<Object[]> sales = q.getResultList();

        return sales;
    }
}
