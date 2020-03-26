package com.backend.controller;

import com.backend.entity.CourseEntity;
import com.backend.service.CourseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseEntityController {

    private CourseEntityService courseEntityService;

    @Autowired
    public CourseEntityController(CourseEntityService courseEntityService){
        this.courseEntityService = courseEntityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseEntity> getAllCourses() {
        return courseEntityService.getAllCourses();
    }

    @RequestMapping (value = "/{idCourse}", method = RequestMethod.GET)
    public ResponseEntity<CourseEntity> getSubjectById(@PathVariable(name = "idCourse") Integer idCourse) {
        Optional<CourseEntity> course = courseEntityService.getCourseById(idCourse);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete/{idCourse}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable(name = "idCourse") Integer idCourse) {
        courseEntityService.deleteCourse(idCourse);
    }
}
