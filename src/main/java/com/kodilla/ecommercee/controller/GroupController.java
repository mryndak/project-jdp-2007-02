package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @GetMapping
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public GroupDto getGroup(@PathVariable("id") Long groupId) throws NotFoundException {
        return groupMapper.mapToGroupDto(groupService.getGroup(groupId));
    }

    @PutMapping("/{id}")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) throws NotFoundException{
        return groupMapper.mapToGroupDto(groupService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto) {
        groupService.createGroup(groupMapper.mapToGroup(groupDto));
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Long groupId) {
        groupService.deleteGroup(groupId);
    }
}