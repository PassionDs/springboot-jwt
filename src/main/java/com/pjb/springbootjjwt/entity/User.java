package com.pjb.springbootjjwt.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jinbin
 * @date 2018-07-08 20:43
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
