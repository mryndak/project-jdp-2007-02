package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroup(final Long id) {
        return groupRepository.findById(id).orElseThrow(()->new NotFoundException("Not found group"));
    }

    public void deleteGroup(final Long id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
        }
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }
}
