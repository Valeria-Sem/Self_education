package com.backend.repository;

import com.backend.entity.PassedTestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassedTestEntityRepository extends CrudRepository<PassedTestEntity, Integer> {
//    Optional<PassedTestEntity> findByStudentIdAndIdTest (int studId, int testId);
    PassedTestEntity findByStudentIdAndIdTest (int studId, int testId);
}
