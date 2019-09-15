package com.manoo.demoapi.exceptionHandling;

import org.springframework.http.HttpStatus;

public abstract class APIBaseException extends RuntimeException{

    public APIBaseException(String message) {
        super(message);
    }

   public abstract HttpStatus getStatusCode();
}
