package com.pjb.springbootjjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pjb.springbootjjwt.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {

    private long expireMillis = 20000;

    public String getToken(User user) {
        String token = JWT.create()
                // 将 user id 保存到 token 里面
                .withAudience(user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + expireMillis))
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
