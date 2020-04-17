package com.z.design.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * <p>
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 * <p>
 * 就是在代理过程中做点事情
 *
 * @author zhangkb
 */
public class Main {

    public static void main(String[] args) {

       System.out.println("------------静态代理------------");
        //静态代理
        IUser myProxy = new MyProxy(new My());
        //MyProxy 代理 new My()
        myProxy.findGirl();


        System.out.println("------------动态代理------------");

        //动态代理
        IUser my = new My();
        IUser proxySubject = (IUser) Proxy.newProxyInstance(my.getClass().getClassLoader(),
                my.getClass().getInterfaces(),
                new MyProxyHandler<>(my));
        proxySubject.findGirl();



        //模拟生成一个class
        ProxyUtil.createClass(my.getClass().getInterfaces());





        //这个跟动态代理是一样的。
        System.out.println("------------匿名代理------------");

        ProxyUtil proxyUtil=new ProxyUtil();
        proxyUtil.<IUser>getProxy(IUser.class,new My()).findGirl();



    }



}
