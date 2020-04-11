package com.backend.controller;

import com.backend.entity.ProductEntity;
import com.backend.entity.StudentEntity;
import com.backend.service.ProductEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductEntityController {
    private ProductEntityService productEntityService;

    @Autowired
    public ProductEntityController(ProductEntityService productEntityService){
        this.productEntityService = productEntityService;
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<ProductEntity> getStudentsByGroupId(@PathVariable(name = "courseId") Integer courseId){
        ProductEntity product = productEntityService.getProductByCourseId(courseId);
        return ResponseEntity.ok(product);
    }
}
