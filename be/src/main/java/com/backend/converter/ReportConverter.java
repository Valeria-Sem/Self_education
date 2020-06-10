package com.backend.converter;

import com.backend.entity.ProductEntity;
import com.backend.entity.StudentEntity;
import com.backend.entity.SubscriptionEntity;
import com.backend.service.ProductEntityService;
import com.backend.service.StudentEntityService;
import com.backend.service.SubscriptionEntityService;
import com.backend.transferOfObjects.ReportModel;
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
@RequestMapping("/api/report")
public class ReportConverter {
    private final SubscriptionEntityService subscriptionEntityService;
    private final ProductEntityService productEntityService;
    private final StudentEntityService studentEntityService;

    @Autowired
    public ReportConverter(SubscriptionEntityService subscriptionEntityService,
                             ProductEntityService productEntityService,
                           StudentEntityService studentEntityService) {
        this.subscriptionEntityService = subscriptionEntityService;
        this.productEntityService = productEntityService;
        this.studentEntityService = studentEntityService;
    }

    @GetMapping
    @RequestMapping(value = "/course/{idProduct}")
    public ResponseEntity<List<ReportModel>> convertSubToProductByIdStudent(@PathVariable String idProduct) {
        int productId = Integer.parseInt(idProduct);
        List<SubscriptionEntity> subs = subscriptionEntityService.getProductSub(productId);
        Iterable<StudentEntity> students = studentEntityService.getAllStudents();
        List<ReportModel> convertSubscription = fillConvertModel(subs, students);
        return ResponseEntity.ok(convertSubscription == null ? Collections.emptyList() : convertSubscription);
    }

    public List<ReportModel> fillConvertModel(List<SubscriptionEntity> subs, Iterable<StudentEntity> students){
        List<ReportModel> convertSubscription = new ArrayList<>();
        for(SubscriptionEntity subsItem: subs) {
            ReportModel reportModel = new ReportModel();
            reportModel.setIdSubscription(subsItem.getIdSubscription());
            for(StudentEntity studItem: students) {
                if (subsItem.getStudentByStudentId() == studItem){
                    reportModel.setStudentId(studItem.getIdStudent());
                    reportModel.setName(studItem.getName());
                    reportModel.setSurname(studItem.getSurname());
                    reportModel.setPatronymic(studItem.getPatronymic());
                }
            }
            convertSubscription.add(reportModel);
        }
        return convertSubscription;
    }
}
