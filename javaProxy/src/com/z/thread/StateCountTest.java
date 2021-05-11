package com.z.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 我们用一个值保存两个数，
 */
public class StateCountTest {
    //  private static final int COUNT_BITS = Integer.SIZE - 3;
    //一半16用来存储高位，一半存低位，（神奇的存储方式。减少变量，减少锁的竞争）
    //一半高3位用来存储状态，低29位存 线程池线程运行数量，（神奇的存储方式。减少变量，减少锁的竞争）
    private static final int COUNT_BITS = 29;//32-3=29
    //看来这个值CAPACITY不是随便写的，他的二进制，都是29位的1，1111111111111111，如果COUNT_BITS是16，就是低位补160，减一个1，结果就是16个1，如果是2，就是2个1。
    // 。(1 << SHARED_SHIFT) - 1;
    private static final int CAPACITY = (1 << COUNT_BITS) -1;

    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;

    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;


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
        //CAPACITY 取反进制是 11100000000000000000000000000000
        //RUNNING  的取进制是 11100000000000000000000000000000
        //todo:敲重点,所以这里是取的高位
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        //CAPACITY 536870911 进制是 00011111111111111111111111111111
        //-536870912 加一 进制是     11100000000000000000000000000001
        //-536870912 加二 进制是     11100000000000000000000000000010
        //& 两个操作数中，位都为1，结果才为1，否则结果为0
        //todo:敲重点,所以这里是取的是低位。
        return c & CAPACITY;
    }

    public static void main(String[] args) {

        System.out.println(runStateOf(RUNNING));
        System.out.println(runStateOf(SHUTDOWN));
        System.out.println(STOP);
        System.out.println(-2 << COUNT_BITS);
        System.out.println(runStateOf(TIDYING));


        System.out.println(workerCountOf(RUNNING));
        System.out.println(workerCountOf(RUNNING+1));
        System.out.println(workerCountOf(RUNNING+2));


    }

}
