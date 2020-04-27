package com.z.handler;

import java.util.concurrent.LinkedBlockingQueue;

public class Looper {

    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    public  static  LinkedBlockingQueue<Message> queue ;
    private Looper() {
    }


    public static void initLooper() {
        queue = new LinkedBlockingQueue<Message>();
        sThreadLocal.set(new Looper());
    }

    public static Looper getLooper() {
        return sThreadLocal.get();
    }



    public static void loop() {

        for (; ; ) {
            try {
                //阻塞
                Message message = queue.take();
                //  System.out.println("----loop----"+queue.size());


                if (message.handler != null) {
                    message.handler.handleMessage(message);
                }

                System.out.println(message.massage);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
