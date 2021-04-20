package com.z.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CountTest {
    //  private static final int COUNT_BITS = Integer.SIZE - 3;
    //一半16用来存储高位，一半存低位，（神奇的存储方式。减少变量，减少锁的竞争）
    private static final int COUNT_BITS = Integer.SIZE - 3;
    //看来这个值CAPACITY不是随便写的，他的二进制，都是1111111111111111
    // 。(1 << SHARED_SHIFT) - 1;
    private static final int CAPACITY = (1 << COUNT_BITS) -1;
    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;

    //private static final int CAPACITY = Integer.SIZE ;
   // private static final int RUNNING = -1 << CAPACITY;


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


        //读写锁也是用的这种状态
        ReentrantReadWriteLock reentrantReadWriteLock;
        //这个是线程的状态
        System.out.println("CAPACITY:"+CAPACITY);
        System.out.println("RUNNING:"+RUNNING);
      //  System.out.println(runStateOf(atomicInteger.get()));

        //System.out.println(workerCountOf(atomicInteger.get()));
        System.out.println("二进制： CAPACITY："+Integer.toBinaryString(CAPACITY));
        System.out.println("二进制：~CAPACITY："+Integer.toBinaryString(~CAPACITY));
        System.out.println("二进制：RUNNING+0："+Integer.toBinaryString(RUNNING));
        System.out.println("二进制：RUNNING+1："+Integer.toBinaryString(RUNNING+1));
        System.out.println("runStateOf："+runStateOf(RUNNING));
        //用来控制线程的数量。
        System.out.println(workerCountOf(RUNNING));
        System.out.println(workerCountOf(RUNNING+1));
        System.out.println(workerCountOf(RUNNING+2));
    }

}
