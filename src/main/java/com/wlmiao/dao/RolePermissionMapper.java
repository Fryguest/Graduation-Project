package com.wlmiao.dao;

import com.wlmiao.model.RolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePermissionMapper {

    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}