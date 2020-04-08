package com.backend.controller;

import com.backend.entity.GroupEntity;
import com.backend.service.GroupEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
@Slf4j
public class GroupEntityController {

    private GroupEntityService groupEntityService;

    @Autowired
    public GroupEntityController(GroupEntityService groupEntityService){
        this.groupEntityService = groupEntityService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<GroupEntity> getAllGroups(){
        return groupEntityService.getAllGroups();
    }
}
