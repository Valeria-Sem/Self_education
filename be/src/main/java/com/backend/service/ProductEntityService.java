package com.backend.service;

import com.backend.entity.ProductEntity;

public interface ProductEntityService {
    ProductEntity saveProduct(ProductEntity product);
    ProductEntity getProductByIdProduct(Integer idProduct);
    ProductEntity getProductByCategory(int idCategory);
    Iterable<ProductEntity> getAllProducts();
    void deleteProduct(Integer idProduct);
}
