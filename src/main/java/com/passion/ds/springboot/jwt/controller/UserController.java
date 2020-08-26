package com.passion.ds.springboot.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.passion.ds.springboot.jwt.annotation.UserLoginToken;
import com.passion.ds.springboot.jwt.api.UserApi;
import com.passion.ds.springboot.jwt.config.ConfigProperties;
import com.passion.ds.springboot.jwt.entity.User;
import com.passion.ds.springboot.jwt.enums.BooleanTypeEnum;
import com.passion.ds.springboot.jwt.enums.LockTypeEnum;
import com.passion.ds.springboot.jwt.service.TokenService;
import com.passion.ds.springboot.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/8/26 10:09
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController implements UserApi {

    private final UserService userService;

    private final TokenService tokenService;

    private final ConfigProperties configProperties;

    /**
     * 登录
     *
     * @param user
     * @return java.lang.Object
     * @author di.mao
     * @date 2020/6/10 13:33
     */
    @Override
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @Override
    public void setTokenStatus(@RequestParam(value = "token", defaultValue = "1") Integer token) {
        configProperties.setToken(BooleanTypeEnum.TRUE.getCode().equals(token) ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public Boolean getTokenStatus() {
        return configProperties.getToken();
    }

    @UserLoginToken
    @Override
    public String getMessage() {
        return "你已通过验证";
    }

    @UserLoginToken
    @Override
    public List<User> getAll() {
        return userService.list();
    }

    @UserLoginToken
    @Override
    public Page<User> page(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        userService.lambdaQuery().eq(User::getIsLock, LockTypeEnum.NOT_LOCKED.getCode()).or().likeRight(User::getUsername,"张").list();
        userService.lambdaQuery().eq(User::getIsLock, LockTypeEnum.NOT_LOCKED.getCode()).likeRight(User::getUsername,"张").list();
        userService.lambdaQuery().eq(User::getIsLock, LockTypeEnum.NOT_LOCKED.getCode()).list();

        return userService.lambdaQuery().page(new Page<>(page, size));
    }


}
