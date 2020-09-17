package com.z.design.interceptor;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:33
 */
public class SubInterceptor implements Interceptor {
    @Override
    public MyResult interceptor(Chain chain) {
        System.out.println("next--："+chain.getNext());

        MyResult myResult = chain.request();
        myResult.setName(myResult.getName()+"--SubInterceptor");
      //  System.out.println("SubInterceptor:"+myResult.getName());
        // 不调用 proceed ，就会停止next
       MyResult result= chain.proceed(myResult);
        System.out.println("这里next  next--："+chain.getNext());
        return myResult;
    }
}
