package com.jin.jin.service.impl;

import com.jin.jin.dao.UserPermissionMapper;
import com.jin.jin.dao.UserRoleMapper;
import com.jin.jin.model.Permission;
import com.jin.jin.model.Role;
import com.jin.jin.service.UserPermissionService;
import com.jin.jin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private UserPermissionMapper userPermissionMapper;


    @Override
    public List<Permission> findByUserName(String userName) {
        return userPermissionMapper.findByUserName(userName);
    }
}
