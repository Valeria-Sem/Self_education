package com.backend.repository;

import com.backend.entity.ProductEntity;
import com.backend.entity.StudentEntity;
import com.backend.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionEntityRepository extends CrudRepository<SubscriptionEntity, Integer> {
    List<SubscriptionEntity> getSubscriptionEntitiesByStudentByStudentId(StudentEntity studentEntity);
    List<SubscriptionEntity> getSubscriptionEntitiesByProductByProductId(ProductEntity product);
    List<SubscriptionEntity> findAll();
}
