package com.z.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/1/25 0025
 * Time: 上午 10:27
 * 拦截器
 */
public class InterceptorMain {


    public static void main(String[] args) {


        List<Interceptor> interceptorList = new ArrayList<>();

        interceptorList.add(new MyInterceptor());
        interceptorList.add(new SubInterceptor());
        interceptorList.add(new Interceptor() {
            @Override
            public MyResult interceptor(Chain chain) {
                // 不调用 proceed ，停止next
                return chain.request();
            }
        });

        //责任链
        MainInterceptor mainInterceptor = new MainInterceptor(interceptorList, 0, new MyResult());
        mainInterceptor.proceed(mainInterceptor.request());
    }


}

class MainInterceptor implements Interceptor.Chain {
    List<Interceptor> interceptorList;
    int next;
    MyResult myResult;

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
        MyResult response = interceptor.interceptor(mainInterceptor);
        System.out.println("next--" + next);
        return response;
    }
}
