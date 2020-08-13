package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.NotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(final Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void deleteUser(final Long id) {
        repository.deleteById(id);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void createUser(User user) {
        repository.save(user);
    }
}
