package com.passion.ds.springboot.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/8/26 11:38
 */
@Component
@Data
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {
    /**
     * token是否开启
     */
    private Boolean token;
}
