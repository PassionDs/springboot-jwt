package com.passion.ds.springboot.jwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@TableName("user")
@Builder
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    Long id;
    @TableField("username")
    @ApiModelProperty(value = "用户名", required = true)
    String username;
    @TableField("password")
    @ApiModelProperty(value = "密码", required = true)
    String password;
    @TableField("phone")
    @ApiModelProperty(value = "手机", required = true)
    String phone;
    @TableField("role")
    @ApiModelProperty(value = "角色", required = true)
    Integer role;
    @TableField("is_lock")
    @ApiModelProperty(value = "是否锁定", required = true)
    Integer isLock;
}
