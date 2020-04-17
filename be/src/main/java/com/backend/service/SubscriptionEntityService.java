package com.backend.service;

import com.backend.entity.SubscriptionEntity;

import java.util.List;

public interface SubscriptionEntityService {
    SubscriptionEntity subscribeStudent(SubscriptionEntity subscriptionEntity, int idStudent, int idProduct);
    void deleteSub(Integer idSubscription);
    List<SubscriptionEntity> getStudentSub(int idStudent);
    List<SubscriptionEntity> getAllSubs();
}
