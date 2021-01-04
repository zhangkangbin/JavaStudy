package com.z.handler;

/**
 * 模仿 ActivityThread
 */
public class LooperTestMain {


    public static void main(String[] args) {

        Looper.initLooper();

        Handler handler1 = new Handler() {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                System.out.println("handleMessage1-----:" +  Looper.getLooper());
                System.out.println("handleMessage1:" + message.massage);


            }
        };
        new Thread() {
            @Override
            public void run() {
                super.run();

                int i = 0;
                while (true) {

                    try {
                        i++;
                        Thread.sleep(1000);

                        handler1.sendMessage(1, "我来自handler1:" + i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();

        Handler handler2 = new Handler() {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                System.out.println("handleMessage2----:" +  Looper.getLooper());
                System.out.println("handleMessage2:" + message.massage);

            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true) {
                    try {
                        i++;
                        Thread.sleep(1000);


                        System.out.println("handleMessage2---------------------:" +   handler1.getLooper());

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        //阻塞 如果线程退出，就无法处理后面的事件了。Activity同理
        Looper.loop();

    }

}
