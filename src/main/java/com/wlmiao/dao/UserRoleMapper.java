package com.wlmiao.dao;

import com.wlmiao.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {

    int insert(UserRole record);

    int insertSelective(UserRole record);
}