package com.wlmiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlmiao.dao.PermissionMapper;
import com.wlmiao.dao.RoleMapper;
import com.wlmiao.dao.UserMapper;
import com.wlmiao.model.User;
import com.wlmiao.service.IUserService;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int save(User user) {
        if (null == userMapper.selectByEmail(user.getEmail())) {
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            return userMapper.insertSelective(user);
        } else {
            return 0;
        }

    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(User user) {
        User existUser = userMapper.selectByPrimaryKey(user.getId());
        if (existUser.getEmail().equals(user.getEmail())) {
            user.setModifyTime(new Date());
            return userMapper.updateByPrimaryKeySelective(user);
        }
        return 0;
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.selectByEmail(username);
    }

    @Override
    public Set<String> findRoleByUserId(Long id) {
        return roleMapper.findRoleByUserId(id);
    }

    @Override
    public Set<String> findPermissionByUserId(Long id) {
        return permissionMapper.findRoleByUserId(id);
    }

    @Override
    public PageInfo<User> find(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> page = new PageInfo<User>(userMapper.select());
        return page;
    }

}
