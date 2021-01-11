package com.z.handler;

/**
 * 测试入口
 * 模仿 android.app.ActivityThread
 * zkb
 */
public class LooperTestMain {

    public static void main(String[] args) {
        Looper.initLooper();
        Handler handler1 = new Handler(msg -> {
            //如果这里为true会拦截消息
            return false;
        }) {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                System.out.println("received a massage from:" + Looper.getLooper());
                System.out.println("this message info:" + message.message);
                System.out.println("Main Thread id:" + Thread.currentThread().getId());
            }
        };

        //通过子线程发消息！
        new Thread() {
            @Override
            public void run() {
                super.run();
                int i = 0;
                    while (true) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Sub Thread id:" + Thread.currentThread().getId());

                        handler1.sendMessage(1, "send a massage:" + i++);
                    }
            }
        }.start();

        //阻塞取消息, 如果线程退出，就无法处理后面的事件了。App ActivityThread同理
        Looper.loop();

        //如果这里被执行了，循环取消息发生异常。android.app.ActivityThread.java中 main 方法中最后一行也是这样写的。
        throw new RuntimeException("Main thread loop unexpectedly exited");

    }

}
