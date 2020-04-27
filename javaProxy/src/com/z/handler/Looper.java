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


                /**
                 * loop怎么知道是哪个Handler，给哪个发消息 ？
                 * 所以消息里面带有 handle 对象。问题迎刃而解
                 */
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
