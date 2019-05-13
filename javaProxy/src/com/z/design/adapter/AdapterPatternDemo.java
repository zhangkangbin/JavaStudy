package com.z.design.adapter;

/**
 * User: zhangkb
 * Date: 2019/5/13 0013
 * Time: 上午 9:44
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {


        BaseAdapter adapterMicroUSB = new MicroUSB();
        adapterMicroUSB.charge();
        System.out.println("===============================");
        BaseAdapter adapterTypeC = new TypeC();
        adapterTypeC.charge();
    }
}
