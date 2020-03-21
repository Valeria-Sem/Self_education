package com.backend.service;

import com.backend.entity.SubjectEntity;

import java.util.Optional;

public interface SubjectEntityService {
    SubjectEntity saveSubject(SubjectEntity subject);
    Optional<SubjectEntity> getSubjectById(Integer idSubject);
    Iterable<SubjectEntity> getAllSubjects();
    void deleteSubject(Integer idSubject);
}
