package com.backend.controller;

import com.backend.entity.QuestionEntity;
import com.backend.service.QuestionEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/question")
@Slf4j
public class QuestionEntityController {
    private final QuestionEntityService questionEntityService;

    @Autowired
    public QuestionEntityController(QuestionEntityService questionEntityService){
        this.questionEntityService = questionEntityService;
    }

    @RequestMapping(value = "/test/{Id}", method = RequestMethod.GET)
    public Iterable<QuestionEntity> getQuestionsByTest(@PathVariable(name = "Id") int Id) {
        return questionEntityService.getQuestionsByTestId(Id);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(ModelMap modelMap) {
//        modelMap.put("questionByQuestionId", questionEntityService.getAllQuestions());
//        return "questionByQuestionId/index";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<QuestionEntity> getAll(){
        return questionEntityService.getAllQuestions();
    }
}
