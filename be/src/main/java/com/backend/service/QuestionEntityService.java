package com.backend.service;

import com.backend.entity.QuestionEntity;

public interface QuestionEntityService {
    Iterable<QuestionEntity> getQuestionsByTestId (int testId);
    Iterable<QuestionEntity> getAllQuestions();
    QuestionEntity getById(int id);
}
