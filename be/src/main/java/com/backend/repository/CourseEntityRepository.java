package com.backend.repository;

import com.backend.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEntityRepository extends CrudRepository<CourseEntity, Integer> {
    CourseEntity getCourseEntityByIdCourse(Integer idCourse);
}
