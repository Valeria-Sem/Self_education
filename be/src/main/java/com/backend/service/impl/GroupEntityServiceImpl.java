package com.backend.service.impl;

import com.backend.entity.GroupEntity;
import com.backend.repository.GroupEntityRepository;
import com.backend.service.GroupEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupEntityServiceImpl implements GroupEntityService {

    private final GroupEntityRepository groupEntityRepository;

    @Autowired
    public GroupEntityServiceImpl(GroupEntityRepository groupEntityRepository){
        this.groupEntityRepository = groupEntityRepository;
    }

    @Override
    public GroupEntity saveGroup(GroupEntity group) {
        return groupEntityRepository.save(group);
    }

    @Override
    public Optional<GroupEntity> getGroupByIdGroup(Integer idGroup) {
        return groupEntityRepository.findById(idGroup);
    }

    @Override
    public Iterable<GroupEntity> getAllGroups() {
        return groupEntityRepository.findAll();
    }

    @Override
    public void deleteGroup(Integer idGroup) {
        groupEntityRepository.deleteById(idGroup);
    }
}
