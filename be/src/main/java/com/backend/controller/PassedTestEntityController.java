package com.backend.controller;

import com.backend.entity.PassedTestEntity;
import com.backend.service.PassedTestEntityService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PassedTestEntityController {
    private final PassedTestEntityService passedTestEntityService;

    public PassedTestEntityController(PassedTestEntityService passedTestEntityService){
        this.passedTestEntityService = passedTestEntityService;
    }

    @RequestMapping(value = "/saveResult", method = RequestMethod.POST)
    public PassedTestEntity saveResult(@RequestBody PassedTestEntity passedTest){
        return passedTestEntityService.save(passedTest);
    }

    @RequestMapping(value = "/findResult/{studId}/{testId}", method = RequestMethod.GET)
    public Optional<PassedTestEntity> findResult(@PathVariable(name = "studId") int studId,
                                                 @PathVariable(name = "testId") int testId){
        return passedTestEntityService.findByStudentIdAndIdTest(studId, testId);
    }
}
