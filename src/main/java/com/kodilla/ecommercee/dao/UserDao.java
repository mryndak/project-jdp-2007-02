package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Long> {
    
}
