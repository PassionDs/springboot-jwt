package com.passion.ds.springboot.jwt;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/9/16 14:11
 */
public class PrivateScope {

    void f() {
        System.out.println("PrivateScope f()");
    }

    public static void main(String[] args) {
        PrivateScope p = new PrivateOverride();
        p.f();
    }
}

class PrivateOverride extends PrivateScope {

    @Override
    protected void f() {
        System.out.println("PrivateOverride f()");
    }
}
