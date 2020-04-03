package com.dbp.ecommapp.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice")

public class Invoice {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Order> orders = new ArrayList<>();

    private Long customerId ;
    private String paymentWay;
    private String paymentStatus = "pending"; // PAID || PENDING
    private final Timestamp date = new Timestamp(System.currentTimeMillis()); // DateTime in mssql
    private Double total ;

    public Invoice() {
    }

    public Invoice(List<Order> orders, Long customerId, String paymentWay, String paymentStatus, Double total) {
        this.orders = orders;
        this.customerId = customerId;
        this.paymentWay = paymentWay;
        this.paymentStatus = paymentStatus;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getDate() {
        return date;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}


