package com.z.design.proxy;

/**
 * User: zhangkb
 * Date: 2019/1/17 0017
 * Time: 下午 3:34
 */
public class MyProxy implements IUser {

    private IUser iUser;

    /**
     * 静态代理
     *
     * @param user
     */
    public MyProxy(IUser user) {
        this.iUser = user;
    }


    @Override
    public void findGirl() {

        System.out.println("我来帮你过滤一点清风，到你那边都是清新的空气。");
        iUser.findGirl();
        System.out.println("我可以继续帮你加油！");
    }

    @Override
    public void findBoy() {
        System.out.println("findBoy start");
        iUser.findBoy();
        System.out.println("findBoy end");
    }
}
