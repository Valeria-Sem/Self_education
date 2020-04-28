package com.backend.repository;

import com.backend.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEntityRepository extends CrudRepository<GroupEntity, Integer> {
}
