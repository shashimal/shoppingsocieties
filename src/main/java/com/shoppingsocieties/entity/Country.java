package com.shoppingsocieties.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.LAZY;

/***
 *
 * Entity class for maintaining country information
 * maps to the 'country' table in shopping_societies database
 *
 */

@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "country", fetch = LAZY)
    private Currency currency;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
