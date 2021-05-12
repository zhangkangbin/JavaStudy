package com.z.thread;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 我们用一个值保存两个数，
 */
public class StateCountTest {
    //一半16用来存储高位，一半存低位，（神奇的存储方式。减少变量，减少锁的竞争）
    //一半高3位用来存储状态，低29位存 线程池线程运行数量，（神奇的存储方式。减少变量，减少锁的竞争）
    private static final int COUNT_BITS = 29;//Integer.SIZE
    //看来这个值CAPACITY不是随便写的，他的二进制，都是29位的1，1111111111111111，如果COUNT_BITS是16，就是低位补160，减一个1，结果就是16个1，如果是2，就是2个1。
    // 。(1 << SHARED_SHIFT) - 1;
    private static final int CAPACITY = (1 << COUNT_BITS) -1;
    private static final int DEFAULT    = -1 << COUNT_BITS;
    private static final int RUNNING   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static AtomicInteger ctl=new AtomicInteger(ctlOf(DEFAULT, 0));

    private static int ctlOf(int rs, int wc) { return rs | wc; }
    /**
     *减少锁的竞争。
     * &与运算
     * 两个操作数中位都为1，结果才为1，否则结果为0
     *  ~即0变成1，1变成0.(简单来说是加一，然后取反)比如 3 ，加一，是4，取反为-4.
     * @param c
     * @return
     */
    private static int runStateOf(int c) {

        //todo:敲重点,所以这里是取的高位
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {

        //todo:敲重点,所以这里是取的是低位。
        return c & CAPACITY;
    }

    /**
     * 增加线程
     * @param expect 预期值
     * @return 是否添加成功。
     */
    private static boolean incrementWorkerCount(int expect) {

        return ctl.compareAndSet(expect, expect + 1);
    }


    /**
     * 减少线程
     * @param expect 预期值
     * @return 是否成功。
     */
    private static boolean decrementWorkerCount(int expect) {

        return ctl.compareAndSet(expect, expect -1);
    }

    /**
     * 修改状态
     * @param state
     * @return
     */
    private static boolean changeState(int state) {

        //修改状态值为stop
        return ctl.compareAndSet(ctl.get(), ctlOf(state, 0));
    }

    public static void main(String[] args) {

        System.out.printf("当前状态：%s \n",runStateOf(ctl.get()));


        changeState(STOP);
        System.out.printf("当前状态：%s \n",runStateOf(ctl.get()));

        //修改状态值为RUNNING
        changeState(RUNNING);
        System.out.printf("当前状态：%s \n",runStateOf(ctl.get()));

        //添加一个线程
        System.out.println("增加一个线程，是否成功："+incrementWorkerCount(ctl.get()));
        //查看线程数
        System.out.println(workerCountOf(ctl.get()));

        System.out.println("增加一个线程，是否成功："+incrementWorkerCount(ctl.get()));
        //查看线程数
        System.out.println(workerCountOf(ctl.get()));


        System.out.println("减少一个线程，是否成功："+decrementWorkerCount(ctl.get()));
        //查看线程数
        System.out.println(workerCountOf(ctl.get()));
    }

}
