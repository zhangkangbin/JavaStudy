package com.z.asm;

/**
 * User: zhangkb
 * Date: 2019/5/21 0021
 * Time: 下午 3:25
 */
class MyClassLoader extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}