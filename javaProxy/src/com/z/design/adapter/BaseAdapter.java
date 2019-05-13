package com.z.design.adapter;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:13
 * @author zhangkb
 */
public abstract class BaseAdapter implements Type {

    /**
     * 充电是公用
     */
    @Override
    public void charge() {
        System.out.println("正在使用" + getType() + "充电......");
        System.out.println("输出电压是"+getVoltage());
    }
}
