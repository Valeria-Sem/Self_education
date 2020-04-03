package com.backend.service.impl;

import com.backend.entity.ProductEntity;
import com.backend.repository.ProductEntityRepository;
import com.backend.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityServiceImpl implements ProductEntityService {

    private final ProductEntityRepository productEntityRepository;

    @Autowired
    public ProductEntityServiceImpl(ProductEntityRepository productEntityRepository){
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        return productEntityRepository.save(product);
    }

    @Override
    public ProductEntity getProductByIdProduct(Integer idProduct) {
        return productEntityRepository.getProductByIdProduct(idProduct);
    }

    @Override
    public ProductEntity getProductByCategory(int idCategory) {
        return productEntityRepository.findByIdCourse(idCategory);
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return productEntityRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productEntityRepository.deleteById(idProduct);
    }
}
