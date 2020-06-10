package com.pjb.springbootjjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pjb.springbootjjwt.config.CustomProperties;
import com.pjb.springbootjjwt.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;


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
                .withAudience(user.getId())
                .withExpiresAt(Date.from(zonedDateTime.toInstant()))
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
