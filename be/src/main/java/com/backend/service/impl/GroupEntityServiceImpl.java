package com.backend.service.impl;

import com.backend.entity.GroupEntity;
import com.backend.repository.GroupEntityRepository;
import com.backend.service.GroupEntityService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GroupEntityServiceImpl implements GroupEntityService {
    private final GroupEntityRepository groupEntityRepository;

    @Autowired
    public GroupEntityServiceImpl(GroupEntityRepository groupEntityRepository){
        this.groupEntityRepository = groupEntityRepository;
    }


    @Override
    public Iterable<GroupEntity> getAllGroups() {
        Iterable<GroupEntity> result = groupEntityRepository.findAll();
        if(result == null){
            log.info("no result!");
            return null;
        }
        return result;
    }

    @Override
    public Optional<GroupEntity> getByIdGroup(int idGroup) {
        return groupEntityRepository.findById(idGroup);
    }
}
