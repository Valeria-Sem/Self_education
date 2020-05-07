package com.backend.repository;

import com.backend.entity.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerEntityRepository extends CrudRepository<AnswerEntity, Integer> {
//    List<AnswerEntity> getAnswerEntitiesByQuestionByQuestionId (QuestionEntity question);
//    List<AnswerEntity> getAll ();
//    List<AnswerEntity> getIdAnswerByQuestionByQuestionId (QuestionEntity question);
    AnswerEntity findByQuestionIdAndIsRight (int questionId, byte isRight);
}
