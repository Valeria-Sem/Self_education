package com.backend.service;

import com.backend.transferOfObjects.RightAnswerModel;

import java.util.List;

public interface RightAnswerModelService {
    public RightAnswerModel getRightAnswers(List<Integer> questionsId, List<Integer> userAnswers);
}
