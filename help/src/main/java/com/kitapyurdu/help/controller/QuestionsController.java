package com.kitapyurdu.help.controller;

import com.kitapyurdu.help.dto.QuestionsDto;
import com.kitapyurdu.help.entity.Questions;
import com.kitapyurdu.help.exception.ExceptionQuestions;
import com.kitapyurdu.help.response.Meta;
import com.kitapyurdu.help.response.QuestionsResponse;
import com.kitapyurdu.help.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @PostMapping("/addQuestions")
    public QuestionsResponse addQuestions(@RequestBody QuestionsDto questionsDto) throws ExceptionQuestions {
        return questionsService.addQuestions(questionsDto);
    }

    @GetMapping("/find/{questionsId}")
    public QuestionsResponse findQuestions(@PathVariable(value = "questionsId")String questionsId){
        QuestionsResponse questionsResponse=new QuestionsResponse();
        Questions questions=questionsService.findQuestions(Integer.parseInt(questionsId));
        return questionsResponse;
    }
}
