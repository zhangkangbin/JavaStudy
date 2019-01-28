package com.z.interceptor;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:33
 */
public class SubInterceptor implements Interceptor {
    @Override
    public MyResult interceptor(Chain chain) {

        MyResult myResult = chain.request();

        System.out.println("SubInterceptor:"+myResult.getName());

        myResult.setName("SubInterceptor");



        return chain.proceed(myResult);
    }
}
