package com.jin.jin.service;


import com.jin.jin.model.Role;

import java.util.List;

public interface UserRoleService {
    List<Role> findByUserName(String userName);
}
