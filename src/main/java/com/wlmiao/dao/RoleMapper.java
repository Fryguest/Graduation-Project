package com.wlmiao.dao;

import com.wlmiao.model.Role;
import java.util.Set;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Set<String> findRoleByUserId(Long id);
}