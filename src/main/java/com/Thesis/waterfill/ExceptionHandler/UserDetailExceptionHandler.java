package com.Thesis.waterfill.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.NotFoundException.UserDetailNotFoundException;


    @RestController
    public class UserDetailExceptionHandler {
        @ExceptionHandler(UserDetailNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)

        String ProfileNotFoundHandler
        (UserDetailNotFoundException e){
            return e.getMessage();
        }
    
        
    }
