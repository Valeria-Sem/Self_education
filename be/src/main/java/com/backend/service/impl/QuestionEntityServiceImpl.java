package com.backend.service.impl;

import com.backend.entity.QuestionEntity;
import com.backend.repository.QuestionEntityRepository;
import com.backend.service.QuestionEntityService;
import com.backend.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionEntityServiceImpl  implements QuestionEntityService {

    private final QuestionEntityRepository questionEntityRepository;

    @Autowired
    public QuestionEntityServiceImpl(QuestionEntityRepository questionEntityRepository){
        this.questionEntityRepository = questionEntityRepository;
    }

    @Override
    public Iterable<QuestionEntity> getQuestionsByTestId(int testId) {
        return questionEntityRepository.getQuestionEntitiesByTestId(testId);
    }

    @Override
    public Iterable<QuestionEntity> getAllQuestions() {
        return questionEntityRepository.findAll();
    }

    @Override
    public QuestionEntity getById(int id) {
        return questionEntityRepository.findByIdQuestion(id);
    }
}
