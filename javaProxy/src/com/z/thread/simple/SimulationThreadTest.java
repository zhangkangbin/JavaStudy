package com.z.thread.simple;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 简单模拟线程池测试入口
 * kang
 */
public class SimulationThreadTest {
    private static volatile int count = 1;
    public static void main(String[] args) {

        SimpleThreadPoolExecutor executor=new SimpleThreadPoolExecutor(3,10,new LinkedBlockingQueue<>());
        //添加一个任务
        executor.execute(() -> {

            //模拟耗时处理任务
            processTask();

        });

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
                        executor.execute(() -> {
                           // 模拟处理任务
                            processTask();
                        });
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


    /**
     * 模拟处理任务
     */
    private static void processTask() {

        //随机休眠
        int sleep = new Random().nextInt(10) * 1000;
        System.out.println("模拟处理任务耗时："+sleep);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

