package com.backend.service.impl;

import com.backend.entity.CourseEntity;
import com.backend.repository.CourseEntityRepository;
import com.backend.service.CourseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseEntityServiceImpl implements CourseEntityService {

    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Override
    public CourseEntity saveCourse(CourseEntity course) {
        return courseEntityRepository.save(course);
    }

    @Override
    public Optional<CourseEntity> getCourseById(Integer idCourse) {
        return courseEntityRepository.findById(idCourse);
    }

    @Override
    public Iterable<CourseEntity> getAllCourses() {
        return courseEntityRepository.findAll();
    }

    @Override
    public void deleteCourse(Integer idCourse) {
        courseEntityRepository.deleteById(idCourse);
    }
}
