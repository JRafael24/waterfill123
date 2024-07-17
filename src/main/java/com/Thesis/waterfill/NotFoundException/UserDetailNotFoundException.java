package com.Thesis.waterfill.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDetailNotFoundException extends RuntimeException {

    public UserDetailNotFoundException(Long id) {
        super("Profile not found with ID: " + id);
    }

    public UserDetailNotFoundException(String message) {
        super(message);
    }
}

