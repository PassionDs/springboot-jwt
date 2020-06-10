package com.pjb.springbootjjwt;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/6/10 14:51
 */
@EnableSwagger2Doc
@SpringBootApplication
@MapperScan("com.pjb.springbootjjwt.mapper")
public class SpringbootJjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJjwtApplication.class, args);
    }

}
