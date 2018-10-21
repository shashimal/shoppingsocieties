package com.shoppingsocieties.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 *
 * Entity class for maintaining sales information
 * maps to the 'Sale' table in shopping_societies database
 *
 */

@Entity
@Table(name = "sale")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price")
    private Double price;

    @Column(name = "total_items")
    private Integer totalItems;

    @Column(name = "items_left")
    private Integer itemsLeft;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime;

    public Sale(){}

    public Sale(Long id, Long productId, Double price, Integer totalItems, Integer itemsLeft, Date startTime, Date endTime, List<SaleEligibleCountry> saleEligibleCountries) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.totalItems = totalItems;
        this.itemsLeft = itemsLeft;
        this.startTime = startTime;
        this.endTime = endTime;
        this.saleEligibleCountries = saleEligibleCountries;
    }

    @OneToMany(
            mappedBy = "sale",
            fetch = FetchType.LAZY
    )
    private List<SaleEligibleCountry> saleEligibleCountries = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(Integer itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<SaleEligibleCountry> getSaleEligibleCountries() {
        return saleEligibleCountries;
    }

    public void setSaleEligibleCountries(List<SaleEligibleCountry> saleEligibleCountries) {
        this.saleEligibleCountries = saleEligibleCountries;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", totalItems=" + totalItems +
                ", itemsLeft=" + itemsLeft +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", saleEligibleCountries=" + saleEligibleCountries +
                '}';
    }
}
