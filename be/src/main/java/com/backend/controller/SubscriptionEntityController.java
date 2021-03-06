package com.backend.controller;

import com.backend.entity.SubscriptionEntity;
import com.backend.entity.UserEntity;
import com.backend.service.SubscriptionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionEntityController {
    private SubscriptionEntityService subscriptionEntityService;

    @Autowired
    public SubscriptionEntityController(SubscriptionEntityService subscriptionEntityService) {
        this.subscriptionEntityService = subscriptionEntityService;
    }

    @RequestMapping(value = "/delete/{idSubscription}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(name = "idSubscription") Integer idSubscription) {
        subscriptionEntityService.deleteSub(idSubscription);
    }

    @RequestMapping(value = "/student/{idStud}/prod/{idProd}",method = RequestMethod.POST)
    public SubscriptionEntity saveSubscription(
            @PathVariable(name = "idStud") Integer idStudent,
            @PathVariable(name = "idProd") Integer idProduct,
            @RequestBody SubscriptionEntity subscriptionEntity){
        return subscriptionEntityService.subscribeStudent(subscriptionEntity, idStudent, idProduct);
    }

    @RequestMapping(value = "/{idStud}/{idProd}",method = RequestMethod.GET)
    public Optional<SubscriptionEntity> getSubscription(
            @PathVariable(name = "idStud") Integer idStudent,
            @PathVariable(name = "idProd") Integer idProduct){
        return subscriptionEntityService.getSubByIdStudAndIdProd(idStudent, idProduct);
    }

    @RequestMapping(method = RequestMethod.POST)
    public SubscriptionEntity save(@RequestBody SubscriptionEntity subscriptionEntity){
        return subscriptionEntityService.save(subscriptionEntity);
    }
}
