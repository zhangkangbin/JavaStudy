package com.z.design.adapter;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:07
 */
public interface Type {
    /**
     * 接入类型
     */
    String getType();

    /**
     * 电压
     * @return
     */
    String getVoltage();
    /**
     * 充电
     */
    void charge();
}
