package com.kitapyurdu.help.service;

import com.kitapyurdu.help.dto.AnswersDto;
import com.kitapyurdu.help.entity.Answers;
import com.kitapyurdu.help.exception.ExceptionAnswers;
import com.kitapyurdu.help.mapper.AnswersMapper;
import com.kitapyurdu.help.repository.AnswersRepository;
import com.kitapyurdu.help.response.AnswersResponse;
import com.kitapyurdu.help.response.QuestionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswersService {
    @Autowired
    AnswersRepository answersRepository;

    @Autowired
    AnswersMapper answersMapper;

    public AnswersResponse addAnswers(AnswersDto answersDto) throws ExceptionAnswers{
        Answers answers=answersMapper.toEntity(answersDto);
        answers=answersRepository.save(answers);
        if (answers == null ){
            throw new ExceptionAnswers();
        }return generatedAnswersResult(answersMapper.toResource(answers));
    }

    private AnswersResponse generatedAnswersResult(AnswersDto toResource) {
        AnswersResponse answersResponse=new AnswersResponse();
        answersResponse.answersDto=toResource;
        return answersResponse;
    }
}
