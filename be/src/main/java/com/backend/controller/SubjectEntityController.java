package com.backend.controller;

import com.backend.entity.SubjectEntity;
import com.backend.service.SubjectEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/subject")
public class SubjectEntityController {

    private SubjectEntityService subjectEntityService;

    @Autowired
    public SubjectEntityController(SubjectEntityService subjectEntityService){
        this.subjectEntityService = subjectEntityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<SubjectEntity> getAllSubjects() {
        return subjectEntityService.getAllSubjects();
    }

    @RequestMapping (value = "/{idSubject}", method = RequestMethod.GET)
    public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable(name = "idSubject") Integer idSubject) {
        Optional<SubjectEntity> subject = subjectEntityService.getSubjectById(idSubject);
        if (subject.isPresent()) {
            return ResponseEntity.ok(subject.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete/{idSubject}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable(name = "idSubject") Integer idSubject) {
        subjectEntityService.deleteSubject(idSubject);
    }
}
