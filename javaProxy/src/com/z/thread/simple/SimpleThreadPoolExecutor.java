package com.z.thread.simple;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 受volley源码的影响
 * 简单模拟线程池
 *
 * todo:备注:任务限制，拒绝策略。
 */
public class SimpleThreadPoolExecutor {
    /**
     * 最大任务数量，超过就不进队列。
     */
    private final int maximumPoolSize;
    /**
     *核心线程数,默认值3
     */
    private volatile int threadSize = 3;
    /**
     * 任务阻塞队列
     */
    private final BlockingQueue<Runnable> workQueue;

    /**
     * 记录目前运行的线程数
     */
    //ThreadPoolExecutor中是用AtomicInteger，代表线程状态和在工作线程数 ,简单起见就不了。待我再写一篇文章吧！这个状态有点意思。
    private final AtomicInteger threadCount = new AtomicInteger(0);

    public SimpleThreadPoolExecutor() {
        //任务上限6，超过拒绝任务。注意：设置小点只是为了好观察。
        this.maximumPoolSize = 6;
        workQueue = new  LinkedBlockingQueue<>();
    }

    public SimpleThreadPoolExecutor(int threadSize,int maximumPoolSize,BlockingQueue<Runnable> workQueue) {
        this.threadSize = threadSize;
        this.maximumPoolSize = maximumPoolSize;

        this.workQueue = workQueue;

    }

    /**
     * 新建线程和添加任务
     * @param task
     */
    public void execute(Runnable task) {

        //判断当前线程，是否启动到最大。（threadSize）
        if (threadCount.get() < threadSize) {
            // ThreadPoolExecutor 的 allowCoreThreadTimeOut 默认也是不回收的，
            // 可见占用的系统资源很少，应该还没有你频繁创建线程的和回收消耗。
            //因为通常将处于阻塞状态的进程排成一个队列， 称为阻塞队列。在有的系统中，
            //按阻塞的原因不同而将处于阻塞状态的进程排成多个队列。
            int count = threadCount.incrementAndGet();
            System.out.println("count：" + count);
            //启动多个线程去取任务。核心也在这里。
            startThread(count);
        }

        int workQueueSize=workQueue.size();
        if(workQueueSize>maximumPoolSize){
            System.out.println("超过最大任务数，拒绝添加任务。thread Count："+workQueueSize);
            return;
        }

        System.out.println("thread Count：" + threadCount.get());
        //添加任务，提示：如果队列超过定义队列大小， Queue full 会抛出异常。
        workQueue.add(task);

    }



    /**
     *取任务和处理任务。
     *process task
     * @param nameTag 为了标识而已
     */
    private void startThread(int nameTag) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    try {
                        //没有任务就阻塞,这里用BlockingQueue，具体看你传递过来的类型。
                        Runnable task = workQueue.take();
                        System.out.println("workQueue size:"+workQueue.size() + "::" + getName() + "--:" + task.toString());
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
    public void removeTask(Runnable obj) {
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

