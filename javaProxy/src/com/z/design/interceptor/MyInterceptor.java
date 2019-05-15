package com.z.design.interceptor;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:33
 */
public class MyInterceptor implements Interceptor {
    @Override
    public MyResult interceptor(Chain chain) {
        System.out.println("next--："+chain.getNext());
        MyResult myResult = chain.request();
        myResult.setName(myResult.getName()+"--MyInterceptor");

        return chain.proceed(myResult);
    }
}
