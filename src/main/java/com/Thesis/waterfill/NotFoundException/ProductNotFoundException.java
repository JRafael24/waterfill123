package com.Thesis.waterfill.NotFoundException;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Could Not Found Product With" + id);
    }

}
