package com.kitapyurdu.help.repository;


import com.kitapyurdu.help.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
    public Questions findQuestionsByQuestionsId(int questionsId);

}
