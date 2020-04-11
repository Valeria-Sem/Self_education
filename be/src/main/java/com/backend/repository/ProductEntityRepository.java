package com.backend.repository;

import com.backend.entity.CourseEntity;
import com.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    ProductEntity getProductEntitiesByCourseId(int courseId);
    ProductEntity getProductByIdProduct(int idProduct);
}
