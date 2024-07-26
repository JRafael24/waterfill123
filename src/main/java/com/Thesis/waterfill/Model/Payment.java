package com.Thesis.waterfill.Model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String paymentId;
    private String productName;
    private int quantity;
    private Date paymentDate;
    private String location;
    private double price;
    

    Payment(){}


    public Payment(Long userId, String paymentId, String productName, int quantity, Date paymentDate, String location,
            double price) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.productName = productName;
        this.quantity = quantity;
        this.paymentDate = paymentDate;
        this.location = location;
        this.price = price;
    }


    public Long getId() {
        return id;
    }


    public Long getUserId() {
        return userId;
    }


    public String getPaymentId() {
        return paymentId;
    }


    public String getProductName() {
        return productName;
    }


    public int getQuantity() {
        return quantity;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }


    public String getLocation() {
        return location;
    }


    public double getPrice() {
        return price;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    

    
   

}

   



