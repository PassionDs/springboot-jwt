package com.passion.ds.springboot.jwt.spi.impl;


import com.passion.ds.springboot.jwt.spi.SPIService;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/9/15 16:18
 */
public class ChineseSPIServiceImpl implements SPIService {

    @Override
    public void saySpi() {
        System.out.println("中文SPI");
    }
}
