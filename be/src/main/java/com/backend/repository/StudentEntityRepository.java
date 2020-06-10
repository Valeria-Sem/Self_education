package com.backend.repository;

import com.backend.entity.StudentEntity;
import com.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentEntityRepository extends CrudRepository<StudentEntity, Integer> {
    StudentEntity getStudentEntityByUserByUserId(UserEntity userEntity);
    StudentEntity getStudentByIdStudent(Integer id);
//    Page<StudentEntity> findByGroupId(Integer groupId, Pageable pageable);
    Iterable<StudentEntity> findByGroupId(Integer groupId);
    List<StudentEntity> getStudentEntitiesByNameOrSurnameOrPatronymicOrderBySurnameAsc (String searchName, String searchSurname, String searchPatronymic);
}
