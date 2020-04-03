package com.dbp.ecommapp.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    private String customerEmail;
    private String customerMobile;
    @Column(name = "customerCity")
    private String city;
    @Column(name = "customerAddress")
    private String address;
    private String img ;
    private final Timestamp date = new Timestamp(System.currentTimeMillis()); // DateTime in mssql
    private String password ;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String customerEmail, String customerMobile, String city, String address, String img, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.customerMobile = customerMobile;
        this.city = city;
        this.address = address;
        this.img = img;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

