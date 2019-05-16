package com.z.asm;



/**
 * User: zhangkb
 * Date: 2019/5/21 0021
 * Time: 上午 10:19
 */

public class Test {

    @MyInjection
    public void test1(){

        System.out.println("-------test time:----------");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
