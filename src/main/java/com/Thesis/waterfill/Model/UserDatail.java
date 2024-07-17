package com.Thesis.waterfill.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDatail {
    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String phoneNumber;
    private String address;
    // Add more fields as needed

    UserDatail() {}

    public UserDatail(String userId,  String phoneNumber, String address) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    

    
}
