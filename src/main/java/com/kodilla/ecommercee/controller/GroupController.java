package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public GroupDto getGroup(@PathVariable("id") Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) throws GroupNotFoundException{
    return groupMapper.mapToGroupDto(groupService.updateGroup(groupDto.getId(),groupDto.getDescription()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteGroup(@PathVariable("id") Long groupId) {
        groupService.deleteGroup(groupId);
    }
}

