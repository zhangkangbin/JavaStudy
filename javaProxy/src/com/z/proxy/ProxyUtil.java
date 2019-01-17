package com.z.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:54
 */
public class ProxyUtil<T> {

    public T getProxy(Class cls,Object target) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{cls},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                        System.out.println("匿名代理 start:我该做点什么？");


                        Object result = method.invoke(target, args);
                        // 获取方法注解
                        Annotation[] annotations = method.getAnnotations();

                        for(Annotation annotation :annotations){

                            if(annotation instanceof MyAnnotation){
                                System.out.println("value:"+((MyAnnotation) annotation).value());
                            }

                        }



                        System.out.println("匿名代理 end:我该做点什么？");
                        return result;




                    }
                });


    }
}
