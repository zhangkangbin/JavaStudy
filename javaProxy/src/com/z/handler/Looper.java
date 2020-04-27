package com.z.handler;

import java.util.concurrent.LinkedBlockingQueue;

public class Looper {

    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();
    Message message;

    private Looper() {

    }

    private static final LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
    private Looper looper;

    public static void initLooper() {
        sThreadLocal.set(new Looper());
    }

    public static Looper getLooper() {
        return sThreadLocal.get();
    }


    public void sendMessage(int what, String msg, Handler handler) {
        queue.add(new Message(what, msg, handler));
    }

    public LinkedBlockingQueue<Message> getQueue() {
        return queue;
    }

    public void startLooper() {
        loop();
    }

    public static void loop() {

        for (; ; ) {
            try {


                Message message = queue.take();
                //  System.out.println("----loop----"+queue.size());


                if (message.handler != null) {
                    message.handler.handleMessage(message);
                }
                System.out.println(message.handler ==null);
                System.out.println(message.massage);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
