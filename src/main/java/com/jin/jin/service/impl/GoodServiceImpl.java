package com.jin.jin.service.impl;

import com.jin.jin.dao.GoodMapper;
import com.jin.jin.dao.UserMapper;
import com.jin.jin.model.Good;
import com.jin.jin.model.User;
import com.jin.jin.service.GoodService;
import com.jin.jin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;


    @Override
    public List<Good> getAllGood() {
        return goodMapper.getAllGood();
    }
}
