package com.wlmiao.service;

import com.github.pagehelper.PageInfo;
import com.wlmiao.model.User;
import java.util.Set;

public interface IUserService {

    int save(User user);

    User getUserById(Long id);

    int update(User user);

    int delete(Long id);

    User findByUsername(String username);

    Set<String> findRoleByUserId(Long id);

    Set<String> findPermissionByUserId(Long id);

    PageInfo<User> find(Integer pageNum, Integer pageSize);

}
