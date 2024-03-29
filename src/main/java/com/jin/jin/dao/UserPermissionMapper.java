package com.jin.jin.dao;

import com.jin.jin.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {
    List<Permission> findByUserName(String userName);
}