package com.kitapyurdu.help.controller;

import com.kitapyurdu.help.dto.AnswersDto;
import com.kitapyurdu.help.entity.Answers;
import com.kitapyurdu.help.exception.ExceptionAnswers;
import com.kitapyurdu.help.response.AnswersResponse;
import com.kitapyurdu.help.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswersController {

    @Autowired
    AnswersService answersService;

    @PostMapping("/addAnswers")
    public AnswersResponse addAnswers(@RequestBody AnswersDto answersDto)throws ExceptionAnswers {
        return answersService.addAnswers(answersDto);
    }
}
