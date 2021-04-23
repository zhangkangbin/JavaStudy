package com.z.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 受volley源码的影响
 * 简单模拟线程池
 *
 */
public class SimulationThreadTest {

    private static int count = 1;
    private static final ArrayBlockingQueue<Task> tasks = new ArrayBlockingQueue<Task>(30);

    public static void main(String[] args) {
        productionString();
        for (int i = 0; i < 2; i++) {
            startThread(i);
        }


    }

    public void remove(Task obj){

        tasks.remove(obj);
    }

    public void clear(){
        tasks.clear();
    }

    /**
     * 模拟生产，主要负责生产任务。
     */
    private static void productionString() {

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
     * @param nameTag
     */
    private static void startThread(int nameTag) {

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();

                    while (true) {

                        try {

                            //没有任务就阻塞
                            Task takeString = tasks.take();
                            String name = getName();
                            System.out.println(tasks.size() + "::" + name + "--:" + takeString);

                            //模拟处理任务
                            processTask();

                        }catch (Exception e){
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
     * @throws InterruptedException
     */
    private static void processTask() throws InterruptedException {

        long sleep = (long) (Math.random() * 10000);
        System.out.println(sleep);
        Thread.sleep(sleep);
    }

}


/**
 * 任务类
 */
class  Task{
    public String tag;
    public Task(String tag){
        this.tag=tag;
    }
}