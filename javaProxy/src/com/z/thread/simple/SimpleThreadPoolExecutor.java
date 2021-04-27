package com.z.thread.simple;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 受volley源码的影响
 * 简单模拟线程池
 *
 * todo:备注:任务限制，拒绝策略。
 */
public class SimpleThreadPoolExecutor {

    //默认值3，核心线程数
    private volatile int threadSize = 3;
    /**
     * 任务队列
     */
    private final BlockingQueue<Task> workQueue;

    //ThreadPoolExecutor中是用AtomicInteger，代表线程状态和在工作线程数 ,简单起见就不了。待我再写一篇文章吧！这个状态有点意思。
    private final AtomicInteger threadCount = new AtomicInteger(0);

    public SimpleThreadPoolExecutor() {
        //任务上限30，超过抛出异常。
        workQueue = new ArrayBlockingQueue<Task>(30);
    }

    public SimpleThreadPoolExecutor(int threadSize, BlockingQueue<Task> workQueue) {
        this.threadSize = threadSize;
        this.workQueue = workQueue;

    }

    /**
     * 新建线程和添加任务
     * @param task
     */
    public void start(Task task) {

        //启动多个线程去取任务。核心也在这里。
        if (threadCount.get() < threadSize) {
            // ThreadPoolExecutor 的 allowCoreThreadTimeOut 默认也是不回收的，
            // 可见占用的系统资源很少，应该还没有你频繁创建线程的和回收消耗。
            //因为通常将处于阻塞状态的进程排成一个队列， 称为阻塞队列。在有的系统中，
            //按阻塞的原因不同而将处于阻塞状态的进程排成多个队列。
            int count = threadCount.incrementAndGet();
            System.out.println("count：" + count);
            startThread(count);
        }

        System.out.println("count：" + threadCount.get());
        //添加任务
        workQueue.add(task);

    }



    /**
     * 模拟处理任务。
     *process task
     * @param nameTag
     */
    private void startThread(int nameTag) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    try {
                        //没有任务就阻塞,这里用ArrayBlockingQueue
                        Task task = workQueue.take();
                        String name = getName();
                        System.out.println("workQueue size:"+workQueue.size() + "::" + name + "--:" + task.tag);

                        //模拟处理任务，和耗时。
                        task.run();

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
     * 移除任务
     *remove task
     * @param obj 任务
     */
    public void removeTask(Task obj) {
        workQueue.remove(obj);
    }

    /**
     * 清除所有任务
     * clear all tasks
     */
    public void clearAllTask() {
        workQueue.clear();
    }

}

