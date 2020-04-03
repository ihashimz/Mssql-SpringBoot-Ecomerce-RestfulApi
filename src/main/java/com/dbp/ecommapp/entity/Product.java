package com.dbp.ecommapp.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName ;
    private int product_qnt ;
    private String type ;
    private String descr;
    private String img ;
    private Double price ;
    private Long sellerId ;
    private final Timestamp date = new Timestamp(System.currentTimeMillis()); // DateTime in mssql


    public Product() {
    }

    public Product(String productName, int product_qnt, String type, String descr, String img, Double price, Long sellerId) {
        this.productName = productName;
        this.product_qnt = product_qnt;
        this.type = type;
        this.descr = descr;
        this.img = img;
        this.price = price;
        this.sellerId = sellerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProduct_qnt() {
        return product_qnt;
    }

    public void setProduct_qnt(int product_qnt) {
        this.product_qnt = product_qnt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Timestamp getDate() {
        return date;
    }
}
