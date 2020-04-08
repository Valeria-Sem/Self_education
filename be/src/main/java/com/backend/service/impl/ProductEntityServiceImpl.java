package com.backend.service.impl;

import com.backend.entity.CourseEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.UserEntity;
import com.backend.repository.CourseEntityRepository;
import com.backend.repository.ProductEntityRepository;
import com.backend.service.ProductEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductEntityServiceImpl implements ProductEntityService {

    private final ProductEntityRepository productEntityRepository;
    private final CourseEntityRepository courseEntityRepository;


    @Autowired
    public ProductEntityServiceImpl(ProductEntityRepository productEntityRepository,
                                    CourseEntityRepository courseEntityRepository){
        this.productEntityRepository = productEntityRepository;
        this.courseEntityRepository = courseEntityRepository;
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
    public ProductEntity getProductByCourse(CourseEntity courseEntity) {
        CourseEntity result = courseEntityRepository.getCourseEntityByIdCourse(courseEntity.getIdCourse());

        if(result == null){
            log.info("Not found course with id: {}", courseEntity.getIdCourse());
            return null;
        } else {
        return productEntityRepository.getProductEntitiesByCourseByCourseId(result);
        }
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
