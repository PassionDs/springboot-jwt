package com.pjb.springbootjjwt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty(value = "主键")
    String id;
    @ApiModelProperty(value = "用户名", required = true)
    String username;
    @ApiModelProperty(value = "密码", required = true)
    String password;
}
