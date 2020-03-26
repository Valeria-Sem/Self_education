package com.backend.service;

import com.backend.entity.CourseEntity;

import java.util.Optional;

public interface CourseEntityService {
    CourseEntity saveCourse(CourseEntity course);
    Optional<CourseEntity> getCourseById(Integer idCourse);
    Iterable<CourseEntity> getAllCourses();
    void deleteCourse(Integer idCourse);
}
