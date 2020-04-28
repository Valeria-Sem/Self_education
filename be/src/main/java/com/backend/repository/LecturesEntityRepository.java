package com.backend.repository;

import com.backend.entity.LecturesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturesEntityRepository extends CrudRepository<LecturesEntity, Integer> {
    Iterable<LecturesEntity> getLecturesEntitiesByProductId(int idProduct);
}
