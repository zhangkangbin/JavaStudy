package com.z.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static final int COUNT_BITS = Integer.SIZE - 3; //29
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;


    // Packing and unpacking ctl
    /**
     *减少锁的竞争。
     * &与运算
     * 两个操作数中位都为1，结果才为1，否则结果为0
     *  ~即0变成1，1变成0.(简单来说是加一，然后取反)比如 3 ，加一，是4，取反为-4.
     * @param c
     * @return
     */
    private static int runStateOf(int c) {
        //~即0变成1，1变成0.(简单来说是加一，然后取反)比如 3 ，加一，是4，取反为-4.
        //CAPACITY =536870911，~后是-536870912
        //CAPACITY的进制是 11111111111111111111111111111
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    /**
     * 或运算符用符号“|”
     * 两个位只要有一个为1，那么结果就是1，否则就为0
     *
     * @param rs
     * @param wc
     * @return
     */
    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    /**
     * 两个位只要有一个为1，那么结果就是1，否则就为0，所以0，二进制都是0。
     * 所以这里的状态都是状态本身的值
     */
    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    public static void main(String[] args) {

        System.out.println("COUNT_BITS:" + COUNT_BITS);
        System.out.println("CAPACITY:" + CAPACITY);
        System.out.println("RUNNING:" + RUNNING);
        System.out.println("SHUTDOWN:" + SHUTDOWN);
        System.out.println("STOP:" + STOP);
        System.out.println("TIDYING:" + TIDYING);
        System.out.println("TERMINATED:" + TERMINATED);

        System.out.println("---------------------------------------");
        System.out.println("两个位只要有一个为1，那么结果就是1，否则就为0，所以0，二进制都是0！");
        System.out.println("ctl.get():" + ctl.get());
        System.out.println("runStateOf RUNNING:" + runStateOf(RUNNING));
        System.out.println("runStateOf SHUTDOWN:" + runStateOf(SHUTDOWN));
        System.out.println("runStateOf STOP :" + runStateOf(STOP));
        System.out.println("runStateOf TIDYING :" + runStateOf(TIDYING));
        System.out.println("runStateOf TERMINATED :" + runStateOf(TERMINATED));
        System.out.println("Integer.MAX_VALUE :" + Integer.MAX_VALUE);


        System.out.println("---------------------------------------");

        System.out.println("ctl.get():" + ctl.get());
        System.out.println("workerCountOf:" + workerCountOf(ctl.get()));
        //工作线程增加。
        System.out.println("compareAndSet:" + ctl.compareAndSet(ctl.get(), ctl.get() + 1));
        System.out.println("compareAndSet:" + ctl.compareAndSet(ctl.get(), ctl.get() + 1));
        System.out.println("compareAndSet:" + ctl.compareAndSet(ctl.get(), ctl.get() + 1));
        System.out.println("workerCountOf:" + workerCountOf(ctl.get()));

        System.out.println("---------------------------------------");

        System.out.println("536870912 TIDYING:" +  (TIDYING));
        System.out.println("536870912 TIDYING:" +  (~TIDYING));
        System.out.println("536870912 ~CAPACITY:" +  ( ~CAPACITY));
        System.out.println("0b1000000000000000000000000000000 ~CAPACITY:" +  0b1000000000000000000000000000000);
        System.out.println("0b1000000000000000000000000000000 ~CAPACITY:" +  0b0011111111111111111111111111111);
        System.out.println("0b1000000000000000000000000000000 ~CAPACITY:" +  0b1111111111111111111111111111100);




        //1073741824 01000000000000000000000000000000
        //-536870912 11100000000000000000000000000000
        System.out.println(" TIDYING:" +  (runStateOf(TIDYING)));

        //1610612736 01100000000000000000000000000000
        //-536870912 11100000000000000000000000000000
        System.out.println(" TERMINATED:" +  (runStateOf(TERMINATED)));



        //32位，不足前面补0，负数前面补1。
        // 536870912 00100000000000000000000000000000
        //-536870912 11100000000000000000000000000000
        System.out.println(" STOP:" +  (runStateOf(STOP)));



        //-536870912 11100000000000000000000000000000
        //-536870912 11100000000000000000000000000000
        System.out.println(" RUNNING:" +  (runStateOf(RUNNING)));
        System.out.println(" RUNNING:" + (3<<10&~-3));
/**
 * 枕上诗书闲处好，五一放假学习佳，何为佳，写文章。
 * day1:Java运算符扫盲
 * day2:实践运行符：线程池源码之线程状态值分析
 * day3:参考线程池源码，100行代码写出自己的线程池。
 * day4:ThreadPoolExecutor线程池源码深度分析
 * day5:（3<<10&~-3)==0？去拍照 : 操作系统进程同步与互斥。
 */


    }
}
