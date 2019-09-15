package com.manoo.demoapi.exceptionHandling;

import org.springframework.http.HttpStatus;

public class ConfilictException extends APIBaseException {


    public ConfilictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
