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
    private String PaymentId;
    private String productName;
    private int Quantity;
    private Date PaymentDate;
    private String Location;
    private double Price;
    

    Payment(){}


    public Payment(String paymentId, String productName, int quantity, Date paymentDate, String location,
            double price) {
        this.PaymentId = paymentId;
        this.productName = productName;
        this.Quantity = quantity;
        this.PaymentDate = paymentDate;
        this.Location = location;
        this.Price = price;
    }


    public Long getId() {
        return id;
    }


    public String getPaymentId() {
        return PaymentId;
    }


    public String getProductName() {
        return productName;
    }


    public int getQuantity() {
        return Quantity;
    }


    public Date getPaymentDate() {
        return PaymentDate;
    }


    public String getLocation() {
        return Location;
    }


    public double getPrice() {
        return Price;
    }


    public void setPaymentId(String paymentId) {
        PaymentId = paymentId;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }


    public void setLocation(String location) {
        Location = location;
    }


    public void setPrice(double price) {
        Price = price;
    }


   

}

   



