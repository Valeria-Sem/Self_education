package com.backend.service;

import com.backend.entity.TestEntity;

public interface TestEntityService {
    TestEntity getByLecture (int lectureId);
    TestEntity getById (int idTest);
}
