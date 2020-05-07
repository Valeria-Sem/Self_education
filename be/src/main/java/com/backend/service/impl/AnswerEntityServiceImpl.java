package com.backend.service.impl;

import com.backend.entity.AnswerEntity;
import com.backend.repository.AnswerEntityRepository;
import com.backend.service.AnswerEntityService;
import com.backend.service.QuestionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerEntityServiceImpl implements AnswerEntityService {
    private final AnswerEntityRepository answerEntityRepository;

    @Autowired
    public AnswerEntityServiceImpl(AnswerEntityRepository answerEntityRepository){
        this.answerEntityRepository = answerEntityRepository;
    }

//    @Override
//    public List<AnswerEntity> findByQuestionId(int questionId) {
//        QuestionEntity question = questionEntityService.getById(questionId);
//        return answerEntityRepository.getAnswerEntitiesByQuestionByQuestionId(question);
//    }

    @Override
    public AnswerEntity findByQuestionIdAndIsRight(int questionId, byte isRight) {
        return answerEntityRepository.findByQuestionIdAndIsRight(questionId, isRight);
    }

    @Override
    public Iterable<AnswerEntity> getAllAnswers() {
        return answerEntityRepository.findAll();
    }
}
