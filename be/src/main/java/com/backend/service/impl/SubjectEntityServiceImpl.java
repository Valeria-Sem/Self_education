package com.backend.service.impl;

import com.backend.entity.SubjectEntity;
import com.backend.repository.SubjectEntityRepository;
import com.backend.service.SubjectEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectEntityServiceImpl implements SubjectEntityService {

    @Autowired
    private SubjectEntityRepository subjectEntityRepository;

    @Override
    public SubjectEntity saveSubject(SubjectEntity subject) {
        return subjectEntityRepository.save(subject);
    }

    @Override
    public Optional<SubjectEntity> getSubjectById(Integer idSubject) {
        return subjectEntityRepository.findById(idSubject);
    }

    @Override
    public Iterable<SubjectEntity> getAllSubjects() {
        return subjectEntityRepository.findAll();
    }

    @Override
    public void deleteSubject(Integer idSubject) {
        subjectEntityRepository.deleteById(idSubject);
    }
}
