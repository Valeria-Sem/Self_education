package com.backend.transferOfObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RightAnswerModel {
    private int mark;
    private List<Integer> questionsId;
    private List<Boolean> isRight;

    public RightAnswerModel() {
    }

    public RightAnswerModel(int mark, List<Integer> questionsId, List<Boolean> isRight) {
        this.mark = mark;
        this.questionsId = questionsId;
        this.isRight = isRight;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public List<Integer> getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(List<Integer> questionsId) {
        this.questionsId = questionsId;
    }

    public List<Boolean> getIsRight() {
        return isRight;
    }

    public void setIsRight(List<Boolean> isRight) {
        this.isRight = isRight;
    }
}
