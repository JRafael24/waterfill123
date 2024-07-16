package com.Thesis.waterfill.NotFoundException;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException (Long id){
        super("Customer not found " + id);
    }
}