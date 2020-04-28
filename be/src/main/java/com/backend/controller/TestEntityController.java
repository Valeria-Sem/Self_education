package com.backend.controller;

import com.backend.entity.TestEntity;
import com.backend.service.TestEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestEntityController {
    private final TestEntityService testEntityService;

    @Autowired
    public TestEntityController(TestEntityService testEntityService){
        this.testEntityService = testEntityService;
    }

    @RequestMapping(value = "/lecture/{Id}", method = RequestMethod.GET)
    public TestEntity getTestByLectures(@PathVariable(name = "Id") int Id) {
        return testEntityService.getByLecture(Id);
    }
}
