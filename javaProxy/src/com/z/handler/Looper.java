package com.z.handler;

public class Looper {

    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<Looper>();

    public    MessageQueue queue ;
    private Looper() {
        queue = new MessageQueue();
    }


    public static void initLooper() {

        sThreadLocal.set(new Looper());
    }

    public static Looper getLooper() {
        return sThreadLocal.get();
    }



    public static void loop() {

        Looper me = getLooper();
        for (; ; ) {
            //没有消息这里就会一直阻塞，有消息就取出来。
            Message message = me.queue.next();
            //  System.out.println("----loop----"+queue.size());

            /**
             * loop怎么知道是哪个Handler，给哪个发消息 ？
             * 所以消息里面带有 handle 对象。问题迎刃而解
             */
            if (message.target != null) {
                message.target.handleMessage(message);
            }

            System.out.println(message.massage);

        }
    }
}
