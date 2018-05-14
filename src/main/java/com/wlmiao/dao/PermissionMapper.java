package com.wlmiao.dao;

import com.wlmiao.model.Permission;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    Set<String> findRoleByUserId(Long id);
}