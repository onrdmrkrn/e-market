package com.kitapyurdu.help.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Questions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionsId;
    private String questions;

    @OneToOne
    private Answers answers;

    public Questions() {
    }

    public Questions(int questionsId, String questions, Answers answers) {
        this.questionsId = questionsId;
        this.questions = questions;
        this.answers = answers;
    }

    public int getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(int questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }
}
