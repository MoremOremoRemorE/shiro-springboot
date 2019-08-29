package com.jin.jin.dao;

import com.jin.jin.model.Good;
import com.jin.jin.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    List<Good> getAllGood();
}
