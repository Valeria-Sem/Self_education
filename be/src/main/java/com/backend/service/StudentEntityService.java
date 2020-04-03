package com.backend.service;

import com.backend.entity.StudentEntity;
import com.backend.entity.UserEntity;

public interface StudentEntityService {
    StudentEntity saveStudent(StudentEntity student);
    StudentEntity getStudentByIdStudent(int idStudent);
    Iterable<StudentEntity> getAllStudents();
    StudentEntity getStudentEntityByUserByIdUser(UserEntity userEntity);
    void deleteStudent(int idStudent);
}
