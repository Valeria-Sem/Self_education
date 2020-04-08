package com.backend.service;

import com.backend.entity.CourseEntity;
import com.backend.entity.ProductEntity;

public interface ProductEntityService {
    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductByIdProduct(Integer idProduct);
    ProductEntity getProductByCourse(CourseEntity courseEntity);
    Iterable<ProductEntity> getAllProducts();
    void deleteProduct(Integer idProduct);
}
