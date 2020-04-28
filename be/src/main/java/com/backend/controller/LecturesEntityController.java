package com.backend.controller;

import com.backend.entity.LecturesEntity;
import com.backend.service.LecturesEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lectures")
@Slf4j
public class LecturesEntityController {
    private final LecturesEntityService lecturesEntityService;

    @Autowired
    public LecturesEntityController(LecturesEntityService lecturesEntityService){
        this.lecturesEntityService = lecturesEntityService;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public Iterable<LecturesEntity> getLecturesByIdProduct(@PathVariable(name = "productId") int productId) {
        return lecturesEntityService.getLecturesByIdProduct(productId);
    }
}
