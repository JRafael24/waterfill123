package com.Thesis.waterfill.NotFoundException;

public class HistoryNotFoundException extends RuntimeException {

    public HistoryNotFoundException(Long id){
        super("History Not Found with This ID: " + id);
    }

}
