package com.jin.jin.service.impl;

import com.jin.jin.dao.UserMapper;
import com.jin.jin.dao.UserRoleMapper;
import com.jin.jin.model.Role;
import com.jin.jin.model.User;
import com.jin.jin.service.UserRoleService;
import com.jin.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> findByUserName(String userName) {
        return userRoleMapper.findByUserName(userName);
    }
}
