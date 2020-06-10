package com.backend.service;

import com.backend.entity.SubscriptionEntity;
import com.backend.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface SubscriptionEntityService {
    SubscriptionEntity subscribeStudent(SubscriptionEntity subscriptionEntity, int idStudent, int idProduct);
    void deleteSub(Integer idSubscription);
    List<SubscriptionEntity> getStudentSub(int idStudent);
    List<SubscriptionEntity> getProductSub(int idProduct);
    List<SubscriptionEntity> getAllSubs();
    Optional<SubscriptionEntity> getSubByIdStudAndIdProd(int idStudent, int idProduct);
    SubscriptionEntity save(SubscriptionEntity subscriptionEntity);
}
