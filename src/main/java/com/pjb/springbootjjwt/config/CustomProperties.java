package com.pjb.springbootjjwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@Component
@Data
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    /**
     * token超时时间
     */
    private long expireMillis;
}
