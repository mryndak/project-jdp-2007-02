package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public GroupDto getGroup(@PathVariable("id") Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteGroup(@PathVariable("id") Long groupId) {
        groupService.deleteGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/{id}")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }
}

