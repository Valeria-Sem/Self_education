package com.backend.service.impl;

import com.backend.entity.PassedTestEntity;
import com.backend.repository.PassedTestEntityRepository;
import com.backend.service.PassedTestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassedTestEntityServiceImpl implements PassedTestEntityService {
    private final PassedTestEntityRepository passedTestEntityRepository;

    @Autowired
    public PassedTestEntityServiceImpl(PassedTestEntityRepository passedTestEntityRepository){
        this.passedTestEntityRepository = passedTestEntityRepository;
    }

    @Override
    public PassedTestEntity save(PassedTestEntity passedTest) {
        return passedTestEntityRepository.save(passedTest);
    }

//    @Override
//    public Optional<PassedTestEntity> findByStudentIdAndIdTest(int studId, int testId) {
//        return passedTestEntityRepository.findByStudentIdAndIdTest(studId, testId);
//    }

    @Override
    public PassedTestEntity findByStudentIdAndIdTest(int studId, int testId) {
        return passedTestEntityRepository.findByStudentIdAndIdTest(studId, testId);
    }
}
