package com.backend.repository;

import com.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductEntityRepository extends CrudRepository<ProductEntity, Integer> {
    ProductEntity findByIdCourse(int idCategory);
    ProductEntity getProductByIdProduct(int idProduct);
}
