package com.manoo.demoapi.exceptionHandling;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class APIexceptionHandller extends ResponseEntityExceptionHandler {



    @ExceptionHandler(APIBaseException.class)
    public ResponseEntity<ErrorMessage> handleAPIException(APIBaseException ex, WebRequest req) {

        ErrorMessage errorMessage =new ErrorMessage(req.getDescription(false),ex.getMessage());

        return new ResponseEntity<>(errorMessage,ex.getStatusCode());

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

       ValidationErrors validationErrors = new ValidationErrors();
       validationErrors.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {

            validationErrors.addError(fieldError.getDefaultMessage());
        }


        return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);

    }
}
