package com.z.design.proxy;

import java.lang.reflect.Proxy;

/**
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 *
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 * @author zhangkb
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("------------静态代理------------");
        //静态代理
        IUser myProxy = new MyProxy(new My());
        myProxy.findGirl();


        System.out.println("------------动态代理------------");

       //动态代理
        IUser my = new My();
        IUser proxySubject = (IUser) Proxy.newProxyInstance(IUser.class.getClassLoader(),
                new Class[]{IUser.class},
                new MyProxyHandler<>(my));
        proxySubject.findGirl();


        System.out.println("------------匿名代理------------");

        ProxyUtil proxyUtil=new ProxyUtil();
        proxyUtil.<IUser>getProxy(IUser.class,new My()).findGirl();




    }

}
