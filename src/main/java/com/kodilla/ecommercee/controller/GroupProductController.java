package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/groups")
public class GroupProductController {

//    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
//    public List<GroupDto> getGroups() {
//        GroupDto groupDto1 = new GroupDto(100L, "RTV");
//        GroupDto groupDto2 = new GroupDto(300L, "Bielizna");
//        GroupDto groupDto3 = new GroupDto(900L, "Obuwie");
//        List<GroupDto> groupDtoList = new ArrayList<>();
//        groupDtoList.add(groupDto1);
//        groupDtoList.add(groupDto2);
//        groupDtoList.add(groupDto3);
//        return groupDtoList;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
//    public GroupDto getGroup(@PathParam("id") Long groupId) {
//        return new GroupDto(500L, "Małe AGD");
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
//        return new GroupDto(500L, "Some Updated Group");
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void createGroup(@RequestBody GroupDto groupDto) {
//    }
}

