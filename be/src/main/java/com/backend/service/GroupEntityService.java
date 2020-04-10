package com.backend.service;

import com.backend.entity.GroupEntity;

import java.util.Optional;

public interface GroupEntityService {
    Iterable<GroupEntity> getAllGroups();
    Optional<GroupEntity> getByIdGroup(int idGroup);
}
