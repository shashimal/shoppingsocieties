package com.shoppingsocieties.entity;

import javax.persistence.*;

/***
 *
 * Entity class for maintaining currency information
 * maps to the 'currency' table in shopping_societies database
 *
 */

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "country_code")
    private Country country;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
