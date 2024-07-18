package com.Thesis.waterfill.Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class History {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Date PaymentDate;
    private int Quantity;
    private String Location;
    private double Price;

    History(){}

    public History(String productName, Date paymentDate, int quantity, String location, double price) {
        this.productName = productName;
        PaymentDate = paymentDate;
        Quantity = quantity;
        Location = location;
        Price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPaymentDate(Date paymentDate) {
        PaymentDate = paymentDate;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getLocation() {
        return Location;
    }

    public double getPrice() {
        return Price;
    }

    


}
