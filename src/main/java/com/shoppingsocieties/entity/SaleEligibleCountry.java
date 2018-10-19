package com.shoppingsocieties.entity;

import javax.persistence.*;
import java.io.Serializable;

/***
 *
 * Entity class for maintaining sales eligible country information
 * maps to the 'sale_eligible_country' table in shopping_societies database
 *
 */

@Entity
@Table(name = "sale_eligible_country")
public class SaleEligibleCountry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "country_code")
    private Country country;

    @OneToOne
    @JoinColumn(name = "currency_code")
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SaleEligibleCountry{" +
                "id=" + id +

                ", country=" + country.getCountryCode() +
                ", currency=" + currency.getCurrencyCode() +
                '}';
    }
}
