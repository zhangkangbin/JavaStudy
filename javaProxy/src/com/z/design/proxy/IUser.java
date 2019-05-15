package com.z.design.proxy;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:29
 */
public interface IUser {

    /**
     * 找女票
     */

    @MyAnnotation(value = "我是自定义注解")
    void findGirl();
}