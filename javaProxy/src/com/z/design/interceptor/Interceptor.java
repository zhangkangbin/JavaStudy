package com.z.design.interceptor;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:33
 */
public interface Interceptor {

    MyResult interceptor(Chain chain);

    interface Chain {

        MyResult request();
        MyResult proceed(MyResult request);
        int getNext();

    }
}
