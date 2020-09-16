package com.passion.ds.springboot.jwt.spi.impl;

import com.passion.ds.springboot.jwt.spi.SPIService;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/9/15 16:33
 */
public class EnglishSPIServiceImpl implements SPIService {

    @Override
    public void saySpi() {
        System.out.println("English SPI");
    }
}
