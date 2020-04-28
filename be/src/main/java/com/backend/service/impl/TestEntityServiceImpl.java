package com.backend.service.impl;

import com.backend.entity.TestEntity;
import com.backend.repository.TestEntityRepository;
import com.backend.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestEntityServiceImpl  implements TestEntityService {
    private final TestEntityRepository testEntityRepository;

    @Autowired
    public TestEntityServiceImpl(TestEntityRepository testEntityRepository){
        this.testEntityRepository = testEntityRepository;
    }

    @Override
    public TestEntity getByLecture(int lectureId) {
        return testEntityRepository.findByLecId(lectureId);
    }

    @Override
    public TestEntity getById(int idTest) {
        return testEntityRepository.findByIdTest(idTest);
    }
}
