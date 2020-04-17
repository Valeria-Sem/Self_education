package com.backend.converter;

import com.backend.entity.ProductEntity;
import com.backend.entity.SubscriptionEntity;
import com.backend.service.ProductEntityService;
import com.backend.service.StudentEntityService;
import com.backend.service.SubscriptionEntityService;
import com.backend.transferOfObjects.StudentProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/studentSub")
public class StudProdConverter {
    private StudentEntityService studentEntityService;
    private SubscriptionEntityService subscriptionEntityService;
    private ProductEntityService productEntityService;

    @Autowired
    public StudProdConverter(StudentEntityService studentEntityService,
                             SubscriptionEntityService subscriptionEntityService,
                             ProductEntityService productEntityService) {
        this.studentEntityService = studentEntityService;
        this.subscriptionEntityService = subscriptionEntityService;
        this.productEntityService = productEntityService;
    }

    @GetMapping
    @RequestMapping(value = "/student/{idStudent}")
    public ResponseEntity<List<StudentProductModel>> convertSubToProductByIdStudent(@PathVariable String idStudent) {
        Integer studentId = Integer.valueOf(idStudent);
        List<SubscriptionEntity> subs = subscriptionEntityService.getStudentSub(studentId);
        Iterable<ProductEntity> products = productEntityService.getAllProducts();
        List<StudentProductModel> convertSubscription = fillConvertModel(subs, products);
        return ResponseEntity.ok(convertSubscription == null ? Collections.emptyList() : convertSubscription);
    }

    public List<StudentProductModel> fillConvertModel(List<SubscriptionEntity> subs, Iterable<ProductEntity> products){
        List<StudentProductModel> convertSubscription = new ArrayList<>();
        for(SubscriptionEntity subsItem: subs) {
            StudentProductModel studProd = new StudentProductModel();
            studProd.setIdSubscription(subsItem.getIdSubscription());
            for(ProductEntity prodItem: products) {
                if (subsItem.getProductByProductId() == prodItem){
                    studProd.setName(prodItem.getProductName());
                    studProd.setDescription(prodItem.getDescription());
                    studProd.setPrice(prodItem.getPrice());
                    studProd.setImg(prodItem.getImg());
                }
            }
            studProd.setSubscriptionStatus(subsItem.getStatus());
            convertSubscription.add(studProd);
        }
        return convertSubscription;
    }
}
