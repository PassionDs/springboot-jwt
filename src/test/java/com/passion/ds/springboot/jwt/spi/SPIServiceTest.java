package com.passion.ds.springboot.jwt.spi;

import org.junit.Test;

import java.util.ServiceLoader;

public class SPIServiceTest {

    @Test
    public void testSPI() {
        ServiceLoader<SPIService> loadedParsers = ServiceLoader.load(SPIService.class);
        for (SPIService spiService : loadedParsers) {
            spiService.saySpi();
        }
    }

}
