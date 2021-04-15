package com.z.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class ThreadMainTest {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("abcdefg");
            }
        });

        executorService.shutdown();


        AtomicInteger atomicInteger=new AtomicInteger();

        atomicInteger.get();

        atomicInteger.set(10);

    }
}
