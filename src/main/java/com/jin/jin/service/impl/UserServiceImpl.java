package com.jin.jin.service.impl;

import com.jin.jin.dao.UserMapper;
import com.jin.jin.model.User;
import com.jin.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
       return userMapper.findByUserName(userName);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
