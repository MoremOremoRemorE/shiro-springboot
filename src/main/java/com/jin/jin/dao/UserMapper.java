package com.jin.jin.dao;

import com.jin.jin.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
}
