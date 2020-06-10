package com.pjb.springbootjjwt.mapper;

import com.pjb.springbootjjwt.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("id") String id);
}
