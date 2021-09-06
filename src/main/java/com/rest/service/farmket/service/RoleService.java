package com.rest.service.farmket.service;

import com.rest.service.farmket.model.Role;

public interface RoleService {
    Role findByName(String name);
}