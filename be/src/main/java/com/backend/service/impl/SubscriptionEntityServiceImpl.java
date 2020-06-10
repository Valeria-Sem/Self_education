package com.backend.service.impl;

import com.backend.entity.ProductEntity;
import com.backend.entity.StudentEntity;
import com.backend.entity.SubscriptionEntity;
import com.backend.repository.SubscriptionEntityRepository;
import com.backend.service.ProductEntityService;
import com.backend.service.StudentEntityService;
import com.backend.service.SubscriptionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionEntityServiceImpl implements SubscriptionEntityService {

    private SubscriptionEntityRepository subscriptionEntityRepository;
    private StudentEntityService studentEntityService;
    private ProductEntityService productEntityService;

    @Autowired
    public SubscriptionEntityServiceImpl(SubscriptionEntityRepository subscriptionEntityRepository, StudentEntityService studentEntityService, ProductEntityService productEntityService) {
        this.subscriptionEntityRepository = subscriptionEntityRepository;
        this.studentEntityService = studentEntityService;
        this.productEntityService = productEntityService;
    }

    @Override
    public SubscriptionEntity subscribeStudent(SubscriptionEntity subscriptionEntity, int idStudent, int idProduct) {
        StudentEntity student = studentEntityService.getStudentByIdStudent(idStudent);
        ProductEntity product = productEntityService. getProductByIdProduct(idProduct);
        subscribe(subscriptionEntity, student, product);
        return null;
    }

    private void subscribe(SubscriptionEntity subscriptionEntity, StudentEntity student, ProductEntity product) {
        SubscriptionEntity subscription = new SubscriptionEntity();
        subscription.setIdSubscription(subscriptionEntity.getIdSubscription());
        subscription.setStudentByStudentId(student);
        subscription.setProductByProductId(product);
        subscription.setStatus(subscriptionEntity.getStatus());

        List<SubscriptionEntity> sub = subscriptionEntityRepository.getSubscriptionEntitiesByStudentByStudentId(student);
        boolean save = true;
        for (SubscriptionEntity subscr: sub){
            if (subscr.getProductByProductId() == subscription.getProductByProductId()) {
                save = false;
                break;
            }
        }
        if(save){
            subscriptionEntityRepository.save(subscription);
        }
    }

    @Override
    public void deleteSub(Integer idSubscription) {
        subscriptionEntityRepository.deleteById(idSubscription);
    }

    @Override
    public List<SubscriptionEntity> getStudentSub(int idStudent) {
        StudentEntity student = studentEntityService.getStudentByIdStudent(idStudent);
        return subscriptionEntityRepository.getSubscriptionEntitiesByStudentByStudentId(student);
    }

    @Override
    public List<SubscriptionEntity> getProductSub(int idProduct) {
        ProductEntity product = productEntityService.getProductByIdProduct(idProduct);
        return subscriptionEntityRepository.getSubscriptionEntitiesByProductByProductId(product);
    }

    @Override
    public List<SubscriptionEntity> getAllSubs() {
        return subscriptionEntityRepository.findAll();
    }

    @Override
    public Optional<SubscriptionEntity> getSubByIdStudAndIdProd(int idStudent, int idProduct) {
        StudentEntity student = studentEntityService.getStudentByIdStudent(idStudent);
        ProductEntity product = productEntityService.getProductByIdProduct(idProduct);
        return subscriptionEntityRepository.getSubscriptionEntitiesByStudentByStudentIdAndProductByProductId(
                student,product);
    }

    @Override
    public SubscriptionEntity save(SubscriptionEntity subscriptionEntity) {
        return subscriptionEntityRepository.save(subscriptionEntity);
    }
}
