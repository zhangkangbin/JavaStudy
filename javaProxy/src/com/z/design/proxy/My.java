package com.z.design.proxy;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:33
 */
public class My implements IUser {
    @Override
    public void findGirl() {
        //
        System.out.println("佛系寻找：你若盛开，清风自来。");
    }

    @Override
    public void findBoy() {
        System.out.println("boy 佛系寻找：你若盛开，清风自来。");
    }


}
