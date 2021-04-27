package com.z.thread.simple;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 受volley源码的影响
 * 简单模拟线程池
 * ThreadPoolExecutor 的 allowCoreThreadTimeOut 默认也是不回收的，可见占用的系统资源很少，应该还没有你频繁创建线程的和回收消耗。
 * 因为通常将处于阻塞状态的进程排成一个队列， 称为阻塞队列。在有的系统中，
 * 按阻塞的原因不同而将处于阻塞状态的进程排成多个队列。
 * todo:备注:任务限制，拒绝策略。
 */
public class SimulationThreadTest {

    //ThreadPoolExecutor中是用AtomicInteger，代表线程状态和在工作线程数
    private static volatile int count = 1;

    public static void main(String[] args) {


        SimpleThreadPoolExecutor executor=new SimpleThreadPoolExecutor();
        //添加一个任务
        executor.start(new Task("first 1"));

        //这一步，只这为了模拟生产任务。
       productionTask(executor);
    }

    /**
     * 模拟生产任务，主要负责生产任务。
     */
    private  static void productionTask( SimpleThreadPoolExecutor executor) {

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                try {

                    while (true) {
                        executor.start(new Task("count:" + count++));
                        sleep(1000);
                        System.out.println("--生产--");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setName("生产");
        thread.start();

    }

}

