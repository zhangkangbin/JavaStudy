package com.z.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 模拟多线程
 */
public class SimulationThreadTest {

    private static int count = 1;
    private static ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(30);

    public static void main(String[] args) {
        productionString();
        for (int i = 0; i < 2; i++) {
            startThread(i);
        }


    }


    private static void productionString() {

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                try {

                    while (true) {
                        strings.put("count:" + count++);
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

    private static void startThread(int nameTag) {

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();

                    while (true) {

                        try {
                            long sleep = (long) (Math.random() * 10000);
                            System.out.println(sleep);
                            sleep(sleep);
                            //没有任务就阻塞
                            String takeString = strings.take();
                            String name = getName();
                            System.out.println(strings.size() + "::" + name + "--:" + takeString);
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }


            }
        };
        thread.setName("tag:" + nameTag);
        thread.start();

    }
}
