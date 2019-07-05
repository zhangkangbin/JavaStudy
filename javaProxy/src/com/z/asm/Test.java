package com.z.asm;


/**
 * User: zhangkb
 * Date: 2019/5/21 0021
 * Time: 上午 10:19
 */

public class Test {
    String _start = "_start";
    @MyInjection
    public void test1() {

        int _test = 11;
        String _test2 = "_test2";
        System.out.println(_test);

    }


}
