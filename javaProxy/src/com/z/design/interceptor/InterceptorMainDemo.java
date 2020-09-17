package com.z.design.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2019/1/25 0025
 * Time: 上午 10:27
 * 拦截器
 * 责任链模式
 * 顾名思义，责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。这种模式给予请求的类型，
 * 对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。
 * 在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
 *
 * 第一个拦截的，最后处理。
 * okhttp 网络请求拦截器也类似如此
 * @author zhangkb
 */
public class InterceptorMainDemo {


    public static void main(String[] args) {


        List<Interceptor> interceptorList = new ArrayList<>();

        interceptorList.add(new MyInterceptor());
        interceptorList.add(new SubInterceptor());
        interceptorList.add(chain -> {
            System.out.println("next--："+chain.getNext());
            // 不调用 proceed ，停止next
            MyResult myResult = chain.request();
            myResult.setName(myResult.getName()+"--Interceptor");

            System.out.println(myResult.getName());


            System.out.println("这里next  next--："+chain.getNext());

            return chain.request();
        });

        //责任链
        MainInterceptor mainInterceptor = new MainInterceptor(interceptorList, 0, new MyResult());
        mainInterceptor.proceed(mainInterceptor.request());
    }


}

