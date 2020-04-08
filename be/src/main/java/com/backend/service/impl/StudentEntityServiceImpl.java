package com.backend.service.impl;

import com.backend.entity.StudentEntity;
import com.backend.entity.UserEntity;
import com.backend.paginationModel.PageStudentModel;
import com.backend.repository.StudentEntityRepository;
import com.backend.service.StudentEntityService;
import com.backend.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentEntityServiceImpl implements StudentEntityService {

    private final StudentEntityRepository studentEntityRepository;
    private final UserEntityService userEntityService;

    @Autowired
    public StudentEntityServiceImpl(StudentEntityRepository studentEntityRepository,
                                    UserEntityService userEntityService){
        this.studentEntityRepository = studentEntityRepository;
        this.userEntityService = userEntityService;
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        return studentEntityRepository.save(student);
    }

    @Override
    public StudentEntity getStudentByIdStudent(int idStudent) {
        return studentEntityRepository.getStudentByIdStudent(idStudent);
    }

    @Override
    public Iterable<StudentEntity> getAllStudents() {
        return studentEntityRepository.findAll();
    }

    @Override
    public StudentEntity getStudentEntityByUserByIdUser(UserEntity userEntity) {
       UserEntity result = userEntityService.getUserIdByLoginAndPassword(userEntity.getLogin(), userEntity.getPassword());

        if(result == null){
            log.info("Student with login: {} not found", userEntity.getLogin());
           return null;
        } else {
        return studentEntityRepository.getStudentEntityByUserByUserId(result); }
    }

    @Override
    public PageStudentModel getStudentByGroupId(Integer groupId, int pageNum, int pageSize) {
        Pageable pageable =  PageRequest.of( pageNum, pageSize, Sort.by("name"));
        Page<StudentEntity> page = studentEntityRepository.findByGroupId(groupId, pageable);
        return new PageStudentModel((int)page.getTotalElements(), page.getContent());
    }

    @Override
    public void deleteStudent(int idStudent) {

    }
}
