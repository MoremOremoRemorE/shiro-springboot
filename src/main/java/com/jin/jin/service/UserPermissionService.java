package com.jin.jin.service;


import com.jin.jin.model.Permission;
import com.jin.jin.model.Role;

import java.util.List;

public interface UserPermissionService {

    List<Permission> findByUserName(String userName);
}
