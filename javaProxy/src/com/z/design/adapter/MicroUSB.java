package com.z.design.adapter;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 10:08
 */
public class MicroUSB  extends BaseAdapter {

    @Override
    public String getType() {
        return "MicroUSB";
    }

    /**
     * USB-A型，到目前为止极限传输速率为5Gbps，输出电压为5伏。
     * @return
     */
    @Override
    public String getVoltage() {
        return "5V";
    }
}
