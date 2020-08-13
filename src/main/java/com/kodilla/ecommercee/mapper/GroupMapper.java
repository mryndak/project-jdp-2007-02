package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    public Group mapToGroup(final GroupDto groupDto) {
        return new Group(groupDto.getId(), groupDto.getDescription(), groupDto.getProducts());
    }

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(),group.getDescription(), group.getProducts());
    }

    public List<GroupDto> mapToGroupDtoList(List<Group> groupList) {
        return groupList.stream().map(this::mapToGroupDto)
                .collect(Collectors.toList());
    }
}
