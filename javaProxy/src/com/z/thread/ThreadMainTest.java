package com.z.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ThreadMainTest {

    static volatile int i=10;
    static volatile boolean isStop=false;

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c)  { return c & CAPACITY; }



    public static void main(String[] args) {


        ReentrantReadWriteLock reentrantReadWriteLock;

        //数字的原子操作，内存
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.get();
        atomicInteger.set(10);
        //i++
        atomicInteger.incrementAndGet();
        //i--
        atomicInteger.decrementAndGet();
        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(5);
        ScheduledThreadPoolExecutor q;
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 10002,
                60L, TimeUnit.SECONDS,queue
                );

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("test"+queue.size());
            }
        });


        System.out.println("COUNT_BITS:"+(COUNT_BITS));
        System.out.println("CAPACITY:"+(CAPACITY));
        System.out.println("CAPACITY:"+(1<<29));
        System.out.println("workerCountOf:"+(workerCountOf(536870912)));


        while (true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                    System.out.println("test"+queue.size());
                }
            });


        }


    }
}
