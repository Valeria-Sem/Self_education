package com.backend.service;

import com.backend.entity.AnswerEntity;

public interface AnswerEntityService {
//    List<AnswerEntity> findByQuestionId (int questionId);
    AnswerEntity findByQuestionIdAndIsRight (int questionId, byte isRight);
    Iterable<AnswerEntity> getAllAnswers();
}
