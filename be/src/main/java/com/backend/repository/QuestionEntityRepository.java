package com.backend.repository;

import com.backend.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionEntityRepository extends CrudRepository<QuestionEntity, Integer> {
    Iterable<QuestionEntity> getQuestionEntitiesByTestId (int testId);
    QuestionEntity findByIdQuestion(int id);
}
