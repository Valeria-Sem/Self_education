package com.backend.controller;

import com.backend.entity.GroupEntity;
import com.backend.service.GroupEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "/{idGroup}", method = RequestMethod.GET)
    public Optional<GroupEntity> getGroupByIdGroup(@PathVariable(name = "idGroup") Integer idGroup){
        return groupEntityService.getByIdGroup(idGroup);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public GroupEntity saveGroup(@RequestBody GroupEntity groupEntity){
        return groupEntityService.saveGroup(groupEntity);
    }
}
