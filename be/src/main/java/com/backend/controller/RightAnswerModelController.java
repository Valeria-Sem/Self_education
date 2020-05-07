package com.backend.controller;

import com.backend.service.RightAnswerModelService;
import com.backend.transferOfObjects.RightAnswerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/right")
public class RightAnswerModelController {

    @Autowired
    private RightAnswerModelService rightAnswerModelService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RightAnswerModel> getRightAnswer(@RequestBody Map<String, String> userAnswersMap) {
        if (userAnswersMap != null) {
            List<Integer> questionsId = new ArrayList<>();
            List<Integer> userAnswers = new ArrayList<>();
            for (Map.Entry<String, String> entry : userAnswersMap.entrySet()) {
                questionsId.add(Integer.valueOf(entry.getKey()));
                userAnswers.add(Integer.valueOf(entry.getValue()));
            }
            return ResponseEntity.ok(rightAnswerModelService.getRightAnswers(questionsId, userAnswers));
        }
        return null;
    }
}
