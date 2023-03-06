package com.z.design.proxy;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:33
 */
public class My extends ServiceMethod {


    @Override
    Object invoke(Object[] args) {


        System.out.println("my ServiceMethod");

        return null;
    }
}
