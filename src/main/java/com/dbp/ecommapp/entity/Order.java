package com.dbp.ecommapp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productId ;
    private String productName ;
    private int qnt ;
    private Long sellerId;
    @Column(name="valueFrom")
    private String from ;
    private Long customerId;
    @Column(name="valueTo")
    private String to ;
    private String orderStatus ;
    private final Timestamp date = new Timestamp(System.currentTimeMillis()); // DateTime in mssql



    public Order() {
    }

    public Order(String productId, String productName, int qnt, Long sellerId, String from, Long customerId, String to, String orderStatus) {
        this.productId = productId;
        this.productName = productName;
        this.qnt = qnt;
        this.sellerId = sellerId;
        this.from = from;
        this.customerId = customerId;
        this.to = to;
        this.orderStatus = orderStatus;


    }

    public Long getId() {
        return id;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getDate() {
        return date;
    }
}
