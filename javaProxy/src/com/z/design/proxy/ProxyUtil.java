package com.z.design.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:54
 */
public class ProxyUtil {

    /**
     * 模仿 Retrofit
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T getProxy(final  Class<T> cls) {

        Class<?>[]  classes= cls.getInterfaces();

        Method[] methods= cls.getDeclaredMethods();

        for (Method m:methods){

            System.out.println("method:"+m.getName());
            System.out.println("method:"+m.toString());
        }

        Deque<Class<?>> check = new ArrayDeque<>(1);
        check.add(cls);
        while (!check.isEmpty()) {
            Class<?> candidate = check.removeFirst();
            if (candidate.getTypeParameters().length != 0) {
                StringBuilder message =
                        new StringBuilder("Type parameters are unsupported on ").append(candidate.getName());
                if (candidate != cls) {
                    message.append(" which is an interface of ").append(cls.getName());
                }
                throw new IllegalArgumentException(message.toString());
            }
            Collections.addAll(check, candidate.getInterfaces());
        }



        return (T) Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{cls},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                        System.out.println("匿名代理 start:我该做点什么？");

                        if (method.getDeclaringClass() == Object.class) {
                            return  method.invoke(this, args);
                        }

                        // 获取方法注解
                        Annotation[] annotations = method.getAnnotations();

                        for (Annotation annotation : annotations) {

                            if (annotation instanceof MyAnnotation) {
                                System.out.println("注解  value:" + ((MyAnnotation) annotation).value());
                            }

                        }


                        System.out.println("匿名代理 end:我该做点什么？");
                        if(method.getReturnType() == My.class){
                            System.out.println("匿名代理 end:My.class？");
                        }
                        if(method.getReturnType() == MyProxy.class){
                            System.out.println("匿名代理 end:MyProxy.class？");
                        }
                        return new My();


                    }
                });


    }

    /**
     * 本地生成一个 testCreate$ProxyClass
     *
     * @param clsInterfaces
     */

    public static void createClass(Class<?>[] clsInterfaces) {

        String name = clsInterfaces[0].getName();
        int n = name.lastIndexOf('.');
        String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
        System.out.println("------------name------------" + name);
        System.out.println("------------name------------" + pkg);
        byte[] testClass = ProxyGenerator.generateProxyClass("testCreate$ProxyClass", clsInterfaces);
        //defineClass0
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("E:\\testCreate$ProxyClass.class");
            out.write(testClass);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
