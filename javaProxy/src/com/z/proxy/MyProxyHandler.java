package com.z.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:43
 * 动态代理
 */
public class MyProxyHandler<T> implements InvocationHandler {


    private T objectProxy;


    public MyProxyHandler(T objectProxy) {
        this.objectProxy = objectProxy;
    }

    /**
     * 动态代理
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start:我该做点什么？");

        Object result = method.invoke(objectProxy, args);

        System.out.println("end:我该做点什么？");
        return result;
    }
}
