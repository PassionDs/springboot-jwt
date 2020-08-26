package com.passion.ds.springboot.jwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.passion.ds.springboot.jwt.entity.User;
import com.passion.ds.springboot.jwt.mapper.UserMapper;
import com.passion.ds.springboot.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Service("UserService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}
