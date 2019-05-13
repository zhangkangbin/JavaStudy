package com.z.design.prototype;

/**
 * Date: 2019/5/13 0013
 * Time: 上午 9:41
 * 原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。
 * 例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，
 * 在需要的时候更新数据库，以此来减少数据库调用。
 * @author zhangkb
 */

public class PrototypePatternDemo{

    public static void main ( String[] args){
        ShallowCopy pro = new ShallowCopy();
        pro.setName("宝儿姐");
        pro.setUserInfo(new UserInfo("123"));

        ShallowCopy proClone = (ShallowCopy)pro.clone();
        proClone.setName("宝儿姐Shallow");
        proClone.getUserInfo().setPhone("9999");

        System.out.println( pro.getName());
        System.out.println( proClone.getName());

        System.out.println( pro.getUserInfo().getPhone());
        //phone 被修改
        System.out.println( proClone.getUserInfo().getPhone());
        /**
         *发生的仅是浅拷贝，即被拷贝对象的所有变量都含有与原来的对象相同的值，
         * 而所有的对其他对象的引用仍然指向原来的对象,所以对象引用还是一致.
         */
        System.out.println(pro+"----"+pro.getUserInfo());
        System.out.println(proClone+"----"+proClone.getUserInfo());


        System.out.println("++++++++++++++++++++++++++++++++++");
        DeepCopy deepCopy = new DeepCopy();
        UserInfo userInfo=new UserInfo("123");
        deepCopy.setUserInfo(userInfo);
        deepCopy.setName("宝儿姐");


        DeepCopy deepCopy2 = (DeepCopy) deepCopy.clone();
        deepCopy2.setName("宝儿姐Deep");
        deepCopy2.getUserInfo().setPhone("Deep321");


        System.out.println(deepCopy.getName());
        System.out.println(deepCopy2.getName());


        System.out.println(deepCopy.getUserInfo().getPhone());
        System.out.println(deepCopy2.getUserInfo().getPhone());

        System.out.println(deepCopy+"----"+deepCopy.getUserInfo());
        System.out.println(deepCopy2+"----"+deepCopy2.getUserInfo());
    }
}