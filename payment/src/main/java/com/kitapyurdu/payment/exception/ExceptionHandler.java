package com.kitapyurdu.payment.exception;

import com.kitapyurdu.payment.response.Meta;
import com.kitapyurdu.payment.response.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleExceptions(EntityNotFoundException exception, WebRequest webRequest){
        PaymentResponse paymentResponse=new PaymentResponse();
        Meta response=new Meta();
        response.errorCode=4304;
        response.errorDesc="Hatalı işlem.";
        paymentResponse.meta=response;
        ResponseEntity<Object> entity=new ResponseEntity<>(paymentResponse, HttpStatus.NOT_FOUND);
        return entity;
    }




}
