package com.pjb.springbootjjwt.service;

import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.mapper.UserMapper;
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
public class UserService {

    private final UserMapper userMapper;

    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

}
