package com.rest.service.farmket.service;

import java.util.List;
import java.util.Map;

import com.rest.service.farmket.model.User;
import com.rest.service.farmket.model.dto.UserDto;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
    String getMarketName(Long id);
    Map<Long, String> getMarketDetails();
    List<User> getAllMarkets();
}
