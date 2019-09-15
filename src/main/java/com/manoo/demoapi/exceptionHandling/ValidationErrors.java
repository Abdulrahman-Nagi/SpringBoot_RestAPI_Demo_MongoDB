package com.manoo.demoapi.exceptionHandling;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationErrors {


    private List<String> errors;

    private String uri;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyy hh:mm")
    private Date timestamp;


    public ValidationErrors() {

        this.errors=new ArrayList<>();
        this.timestamp=new Date();
    }


    public void addError(String error) {
        this.errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
