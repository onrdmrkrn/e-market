package com.kitapyurdu.help.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Answers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int answersId;
    private String answers;

    public Answers() {
    }

    public Answers(int answersId, String answers) {
        this.answersId = answersId;
        this.answers = answers;
    }

    public int getAnswersId() {
        return answersId;
    }

    public void setAnswersId(int answersId) {
        this.answersId = answersId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
