package com.backend.repository;

import com.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    ProductEntity getProductEntitiesByCourseId(int courseId);
    ProductEntity getProductByIdProduct(int idProduct);
}
