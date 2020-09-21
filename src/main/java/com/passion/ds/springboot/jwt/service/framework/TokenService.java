package com.passion.ds.springboot.jwt.service.framework;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.passion.ds.springboot.jwt.entity.User;
import com.passion.ds.springboot.jwt.config.CustomProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;


/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Service("TokenService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TokenService {

    private final CustomProperties customProperties;

    public String getToken(User user) {
        long expireMillis = customProperties.getExpireMillis();
        ZonedDateTime zonedDateTime =
                LocalDateTime.now().plus(expireMillis, ChronoUnit.MILLIS).atZone(ZoneId.systemDefault());
        return JWT.create()
                // 将 user id 保存到 token 里面
                .withAudience(String.valueOf(user.getId()))
                .withExpiresAt(Date.from(zonedDateTime.toInstant()))
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
