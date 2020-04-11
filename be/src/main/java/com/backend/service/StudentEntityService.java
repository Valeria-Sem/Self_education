package com.backend.service;

import com.backend.entity.StudentEntity;
import com.backend.entity.UserEntity;
import com.backend.paginationModel.PageStudentModel;

import java.util.Optional;

public interface StudentEntityService {
    StudentEntity saveStudent(StudentEntity student);
    StudentEntity getStudentByIdStudent(int idStudent);
    Iterable<StudentEntity> getAllStudents();
    StudentEntity getStudentEntityByUserByIdUser(UserEntity userEntity);
//    PageStudentModel getStudentByGroupId(Integer groupId, int pageNum, int pageSize);
    Iterable<StudentEntity> getStudentByGroupId(Integer groupId);
    void deleteStudent(int idStudent);
}