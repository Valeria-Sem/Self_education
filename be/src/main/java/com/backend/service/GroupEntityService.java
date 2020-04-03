package com.backend.service;

import com.backend.entity.GroupEntity;

import java.util.Optional;

public interface GroupEntityService {
    GroupEntity saveGroup(GroupEntity group);
    Optional<GroupEntity> getGroupByIdGroup(Integer idGroup);
    Iterable<GroupEntity> getAllGroups();
    void deleteGroup(Integer idGroup);
}
