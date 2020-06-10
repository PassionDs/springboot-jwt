package com.passion.ds.springboot.jwt.api;

import com.alibaba.fastjson.JSONObject;
import com.passion.ds.springboot.jwt.annotation.UserLoginToken;
import com.passion.ds.springboot.jwt.entity.User;
import com.passion.ds.springboot.jwt.service.TokenService;
import com.passion.ds.springboot.jwt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Api(tags = "用户操作", protocols = "application/json")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserApi {

    private final UserService userService;

    private final TokenService tokenService;

    /**
     * 登录
     *
     * @param user
     * @return java.lang.Object
     * @author di.mao
     * @date 2020/6/10 13:33
     */
    @ApiOperation(value = "用户登录 # Passion_Ds/2020-06-10#", notes = "用户登录", nickname = "UserApi" +
            "-login")
    @ApiImplicitParam(name = "user", value = "用户", type = "body", required = true, dataType =
            "User")
    @PostMapping("/login")
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

    @ApiOperation(value = "验证 # Passion_Ds/2020-06-10#", notes = "验证", nickname = "UserApi" +
            "-getMessage")
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}