package com.dbp.ecommapp.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "seller")

public class Seller {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String sellerEmail;
    private String sellerMobile;
    @Column(name = "sellerCity")
    private String city;
    @Column(name = "sellerAddress")
    private String address;
    private final Timestamp date = new Timestamp(System.currentTimeMillis()); // DateTime in mssql
    private String password;


    public Seller(String firstName, String lastName, String sellerEmail, String sellerMobile, String city, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sellerEmail = sellerEmail;
        this.sellerMobile = sellerMobile;
        this.city = city;
        this.address = address;
        this.password = password;
    }

    public Seller() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerMobile() {
        return sellerMobile;
    }

    public void setSellerMobile(String sellerMobile) {
        this.sellerMobile = sellerMobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
