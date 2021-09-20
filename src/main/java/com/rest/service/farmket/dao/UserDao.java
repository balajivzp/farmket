package com.rest.service.farmket.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.service.farmket.model.Role;
import com.rest.service.farmket.model.User;



@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByRoles(Role role);
   
    
}