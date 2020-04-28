package com.backend.repository;

import com.backend.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntityRepository extends CrudRepository<TestEntity, Integer> {
    TestEntity findByLecId (int lectureId);
    TestEntity findByIdTest(int idTest);
}
