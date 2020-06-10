package com.backend.converter;

import com.backend.entity.PassedTestEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.SubscriptionEntity;
import com.backend.service.PassedTestEntityService;
import com.backend.service.ProductEntityService;
import com.backend.service.SubscriptionEntityService;
import com.backend.service.TestEntityService;
import com.backend.transferOfObjects.StudentProductModel;
import com.backend.transferOfObjects.TestingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testing")
public class TestingConverter {
    private final PassedTestEntityService passedTestEntityService;

    @Autowired
    public TestingConverter(PassedTestEntityService passedTestEntityService) {
        this.passedTestEntityService = passedTestEntityService;
    }

    @GetMapping
    @RequestMapping(value = "/{idStudent}/{idTest}")
    public ResponseEntity<TestingModel> convertTesting(@PathVariable String idTest,
                                                       @PathVariable String idStudent) {
        int studentId = Integer.parseInt(idStudent);
        int testId = Integer.parseInt(idTest);
        PassedTestEntity passedTest = passedTestEntityService.findByStudentIdAndIdTest(studentId, testId);
        TestingModel convertPassedTest = fillConvertModel(passedTest);
        return ResponseEntity.ok(convertPassedTest);
    }

    public TestingModel fillConvertModel(PassedTestEntity passedTest){
        boolean isExist = false;
        if(passedTest != null){
            isExist = true;
            return new TestingModel(
                    passedTest.getIdPassedTest(),
                    passedTest.getStudentId(),
                    passedTest.getIdTest(),
                    passedTest.getMark(),
                    isExist);
        } else {
            return new TestingModel(isExist);
        }
    }
}
