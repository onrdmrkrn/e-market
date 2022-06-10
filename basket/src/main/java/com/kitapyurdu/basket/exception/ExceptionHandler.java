package com.kitapyurdu.basket.exception;

import com.kitapyurdu.basket.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(EntityNotFoundException exception, WebRequest webRequest) {
        Meta response = new Meta();
        response.errorCode = 5007;
        response.errorDesc = "Entity bulunamadı";
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(findBasketException.class)
    public ResponseEntity<Object> handleExceptions(findBasketException exception, WebRequest webRequest) {
        Meta response = new Meta();
        response.errorCode = 5007;
        response.errorDesc = "Basket bulunamadı";
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}