package com.Thesis.waterfill.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
    public Long getId() {
        return id;
    }

    private @Id
    @GeneratedValue Long id;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private String url;

    Product(){}

    public Product(String productName, String description, double price, int quantity, String url) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
    }


    //Getters

    public Long Id() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUrl() {
        return url;
    }

    //Setters
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

}
