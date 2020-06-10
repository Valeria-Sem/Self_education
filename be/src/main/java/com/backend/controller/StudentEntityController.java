package com.backend.controller;

import com.backend.entity.StudentEntity;
import com.backend.service.StudentEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Slf4j
public class StudentEntityController {
    private StudentEntityService studentEntityService;

    @Autowired
    public StudentEntityController(StudentEntityService studentEntityService){
        this.studentEntityService = studentEntityService;
    }

//    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
//    public ResponseEntity<PageStudentModel> getStudentsByGroupId(@PathVariable(name = "groupId") Integer groupId,
//                                                                 @RequestParam(name = "offset") int offset,
//                                                                 @RequestParam(name = "limit") int limit){
//        PageStudentModel products = studentEntityService.getStudentByGroupId(groupId, offset, limit);
//        return ResponseEntity.ok(products);
//
//    }

    @RequestMapping(value = "/group/{groupId}", method = RequestMethod.GET)
    public Iterable<StudentEntity> getStudentsByGroupId(@PathVariable(name = "groupId") Integer groupId){
        return studentEntityService.getStudentByGroupId(groupId);
    }

    @RequestMapping (value = "/{idStudent}", method = RequestMethod.GET)
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable(name = "idStudent") Integer idStudent) {
        StudentEntity student = studentEntityService.getStudentByIdStudent(idStudent);
        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/search")
    public List<StudentEntity> getStudentsBySearch(@RequestParam(name="request") String searchWord) {
        return studentEntityService.getStudentsBySearch(searchWord);
    }
}
