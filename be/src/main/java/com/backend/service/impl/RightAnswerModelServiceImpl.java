package com.backend.service.impl;

import com.backend.entity.AnswerEntity;
import com.backend.service.RightAnswerModelService;
import com.backend.transferOfObjects.RightAnswerModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RightAnswerModelServiceImpl implements RightAnswerModelService {
    @Value("http://localhost:5051/")
    private String backendServerURL;

    @Override
    public RightAnswerModel getRightAnswers(List<Integer> questionsId, List<Integer> userAnswers) {
        RestTemplate restTemplate = new RestTemplate();
        List<Integer> rightAnswers = new ArrayList<>();

        byte isRightByte = 1;
        for (Integer questionId : questionsId) {
            AnswerEntity rightAnswer = restTemplate.getForObject(backendServerURL + "api/rightAnswers/?questionId="
                    + questionId + "&isRight=" + isRightByte, AnswerEntity.class);
            assert rightAnswer != null;
            rightAnswers.add(rightAnswer.getIdAnswer());
        }

        List<Boolean> isRight = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equals(rightAnswers.get(i))) {
                sum += 1;
                isRight.add(true);
            } else {
                isRight.add(false);
            }
        }
        System.out.println(sum);
        int percent = sum;


        return new RightAnswerModel(percent, questionsId, isRight);
    }
}
