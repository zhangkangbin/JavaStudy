package com.z.interceptor;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:33
 */
public class MyInterceptor implements Interceptor {
    @Override
    public MyResult interceptor(Chain chain) {

        MyResult myResult = chain.request();

        System.out.println("MyInterceptor:"+myResult.getName());

        myResult.setName("MyInterceptor");

        return chain.proceed(myResult);
    }
}
