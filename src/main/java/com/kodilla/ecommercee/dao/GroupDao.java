package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GroupDao extends CrudRepository<Group, Long> {

}