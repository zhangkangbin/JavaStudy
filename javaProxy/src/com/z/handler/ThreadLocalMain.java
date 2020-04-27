package com.z.handler;

public class ThreadLocalMain {

    /**
     * 每个线程都有一个局部变量，互不干扰。
     */
    private static ThreadLocal<String> localVar = new ThreadLocal<>();

    public static void main(String[] args) {


        localVar.set("default ThreadLocal");
        new Thread(){
            @Override
            public void run() {
                super.run();

                localVar.set("test11");
                String s = localVar.get();


                System.out.println("Sub1 Thread:"+s);
                System.out.println(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                super.run();

                localVar.set("test22");
                String s = localVar.get();

                System.out.println("Sub2 Thread:"+s);
                System.out.println(Thread.currentThread());
            }
        }.start();


        String mainString = localVar.get();
        System.out.println(Thread.currentThread());
        System.out.println("Main Thread:"+mainString);
    }
}
