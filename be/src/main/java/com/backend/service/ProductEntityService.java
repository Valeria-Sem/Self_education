package com.backend.service;

import com.backend.entity.ProductEntity;

public interface ProductEntityService {
    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductByIdProduct(Integer idProduct);
    ProductEntity getProductByCourseId(int courseId);
    Iterable<ProductEntity> getAllProducts();
    void deleteProduct(Integer idProduct);
}
