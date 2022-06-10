package com.kitapyurdu.auth.exception;

import com.kitapyurdu.auth.response.Meta;
import com.kitapyurdu.auth.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(UserLoginException.class)
    public ResponseEntity<Object> loginException(UserLoginException exception, WebRequest webRequest) {
        UserResponse userResponse = new UserResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = " Mail Adresi veya Şifreyi Kontrol Ediniz.";
        userResponse.meta = response;
        ResponseEntity<Object> entity = new ResponseEntity<>(userResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
