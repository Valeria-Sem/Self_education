package com.backend.service;

import com.backend.entity.PassedTestEntity;

import java.util.Optional;

public interface PassedTestEntityService {
    PassedTestEntity save(PassedTestEntity passedTest);
//    Optional<PassedTestEntity> findByStudentIdAndIdTest (int studId, int testId);
    PassedTestEntity findByStudentIdAndIdTest (int studId, int testId);
}
