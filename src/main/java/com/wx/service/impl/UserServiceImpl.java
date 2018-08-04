package com.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wx.service.UserService;
import com.wx.bean.User;
import com.wx.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

}
