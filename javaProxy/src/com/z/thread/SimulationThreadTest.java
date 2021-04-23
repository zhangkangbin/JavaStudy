package com.z.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 受volley源码的影响
 * 简单模拟线程池
 * todo:备注:任务限制，拒绝策略。
 */
public class SimulationThreadTest {

    private static int count = 1;
    private static final int threadSize = 3;
    private static final ArrayBlockingQueue<Task> tasks = new ArrayBlockingQueue<Task>(30);

    public static void main(String[] args) {

        //模拟生产任务
        productionTask();

        //启动多个线程去取任务。核心也在这里。
        for (int i = 0; i < threadSize; i++) {
            startThread(i);
        }

    }

    /**
     * 移除任务
     *
     * @param obj 任务
     */
    public void remove(Task obj) {
        tasks.remove(obj);
    }

    /**
     * 清除所有任务
     */
    public void clear() {
        tasks.clear();
    }

    /**
     * 模拟生产任务，主要负责生产任务。
     */
    private static void productionTask() {

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                try {

                    while (true) {
                        tasks.put(new Task("count:" + count++));
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
     * 模拟处理任务。
     *
     * @param nameTag
     */
    private static void startThread(int nameTag) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {

                    try {

                        //没有任务就阻塞,这里用ArrayBlockingQueue
                        Task takeString = tasks.take();
                        String name = getName();
                        System.out.println(tasks.size() + "::" + name + "--:" + takeString);

                        //模拟处理任务
                        processTask();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        };
        thread.setName("tag:" + nameTag);
        thread.start();

    }

    /**
     * 模拟处理任务
     *
     * @throws InterruptedException
     */
    private static void processTask() throws InterruptedException {
        //随机休眠
        int  sleep= new Random().nextInt( 10 )*1000;
        System.out.println(sleep);
        Thread.sleep(sleep);
    }
}

/**
 * 任务类
 */
class Task {
    public String tag;

    public Task(String tag) {
        this.tag = tag;
    }
}