package com.z.interceptor;


/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:32
 */
public class Chain {


    public MyResult proceed() {

        MyResult result = new MyResult();
        result.setName("start Name");
        return result;

    }
}
