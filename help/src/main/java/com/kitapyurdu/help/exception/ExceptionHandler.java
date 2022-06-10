package com.kitapyurdu.help.exception;

import com.kitapyurdu.help.response.Meta;
import com.kitapyurdu.help.response.QuestionsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> addException(ExceptionQuestions exception, WebRequest webRequest) {
        QuestionsResponse questionsResponse=new QuestionsResponse();
        Meta response = new Meta();
        response.errorCode = 6112;
        response.errorDesc = "Soru eklemede bir sorun oluştu";
        questionsResponse.meta=response;
        ResponseEntity<Object> entity = new ResponseEntity<>(questionsResponse, HttpStatus.NOT_FOUND);
        return entity;
    }
}
