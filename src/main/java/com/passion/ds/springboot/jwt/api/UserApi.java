package com.passion.ds.springboot.jwt.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.passion.ds.springboot.jwt.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Api(tags = "用户操作", protocols = "application/json")
@RequestMapping("/api/user")
public interface UserApi {

    @ApiOperation(value = "用户登录 # Passion_Ds/2020-06-10#", notes = "用户登录", nickname = "UserApi" +
            "-login")
    @ApiImplicitParam(name = "user", value = "用户", type = "body", required = true, dataType =
            "User")
    @PostMapping("/login")
    Object login(@RequestBody User user);

    @ApiOperation(value = "设置使用token状态 # Passion_Ds/2020-06-10#", notes = "设置使用token状态", nickname = "UserApi" +
            "-setTokenStatus")
    @ApiImplicitParam(name = "token", value = "0-关闭,1-开启", type = "query", required = true, dataType =
            "int")
    @PutMapping("/set_token_status")
    void setTokenStatus(@RequestParam("token") Integer token);

    @ApiOperation(value = "获取token使用状态 # Passion_Ds/2020-06-10#", notes = "获取token使用状态", nickname = "UserApi" +
            "-getTokenStatus")
    @GetMapping("/get_token_status")
    Boolean getTokenStatus();

    @ApiOperation(value = "验证 # Passion_Ds/2020-06-10#", notes = "验证", nickname = "UserApi" +
            "-getMessage")
    @GetMapping("/getMessage")
    String getMessage();

    @ApiOperation(value = "获取所有用户 # Passion_Ds/2020-06-10#", notes = "验证", nickname = "UserApi" +
            "-getAll")
    @GetMapping("/getAll")
    List<User> getAll();

    @ApiOperation(value = "分页查询用户 # Passion_Ds/2020-06-10#", notes = "分页查询用户", nickname = "UserApi" +
            "-page")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", type = "query", required = true, dataType =
                    "int"),
            @ApiImplicitParam(name = "size", value = "每页数量", type = "query", required = true, dataType =
                    "int")})
    @GetMapping("/page")
    Page<User> page(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
}
