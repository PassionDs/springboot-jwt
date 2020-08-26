package com.passion.ds.springboot.jwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.passion.ds.springboot.jwt.entity.User;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
public interface UserService extends IService<User> {

    User findByUsername(User user);

    User findUserById(String userId);

}
