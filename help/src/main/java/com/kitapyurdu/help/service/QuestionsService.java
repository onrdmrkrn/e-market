package com.kitapyurdu.help.service;

import com.kitapyurdu.help.dto.QuestionsDto;
import com.kitapyurdu.help.entity.Questions;
import com.kitapyurdu.help.exception.ExceptionQuestions;
import com.kitapyurdu.help.mapper.QuestionsMapper;
import com.kitapyurdu.help.repository.QuestionsRepository;
import com.kitapyurdu.help.response.QuestionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class QuestionsService {
    @Autowired
    QuestionsRepository questionsRepository;

    @Autowired
    QuestionsMapper questionsMapper;

    public QuestionsResponse addQuestions(QuestionsDto questionsDto) throws ExceptionQuestions {
        Questions questions=questionsMapper.toEntity(questionsDto);
        questions=questionsRepository.save(questions);
        if (questions == null){
            throw new ExceptionQuestions();
        }return generatedQuestionResult(questionsMapper.toResource(questions));
    }

    public QuestionsResponse generatedQuestionResult(QuestionsDto toResource) {
        QuestionsResponse questionsResponse=new QuestionsResponse();
        questionsResponse.questionsDto=toResource;
        return questionsResponse;
    }

    public Questions findQuestions(int questionsId) throws EntityNotFoundException{
        Questions questions=questionsRepository.findQuestionsByQuestionsId(questionsId);
        if (questions == null){
            throw new EntityNotFoundException();
        }
        return questions;
    }
}
