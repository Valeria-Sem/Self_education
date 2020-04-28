package com.backend.controller;

import com.backend.service.AnswerEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
@Slf4j
public class AnswerEntityController {
    private final AnswerEntityService answerEntityService;

    @Autowired
    public AnswerEntityController(AnswerEntityService answerEntityService){
        this.answerEntityService = answerEntityService;
    }

//    @RequestMapping(value = "/question/{Id}", method = RequestMethod.GET)
//    public List<AnswerEntity> getByQuestionsId(@PathVariable(name = "Id") int Id) {
//        return answerEntityService.findByQuestionId(Id);
//    }
}
