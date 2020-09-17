package com.z.design.interceptor;

import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/5/15 0015
 * Time: 下午 3:00
 */
class MainInterceptor implements Interceptor.Chain {
    private List<Interceptor> interceptorList;

    @Override
    public int getNext() {
        return next;
    }


    private int next;
    private MyResult myResult;

    MainInterceptor(List<Interceptor> interceptorList, int next, MyResult myResult) {

        this.interceptorList = interceptorList;
        this.next = next;
        this.myResult = myResult;

    }

    @Override
    public MyResult request() {
        return myResult;
    }

    @Override
    public MyResult proceed(MyResult request) {

        MainInterceptor mainInterceptor = new MainInterceptor(interceptorList, next + 1, request);
        Interceptor interceptor = interceptorList.get(next);

        //执行下一个interceptor
        MyResult response = interceptor.interceptor(mainInterceptor);
        //  System.out.println("这里next--" + next);
        return response;
    }
}
