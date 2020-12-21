package com.z.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessageQueue {
    //阻塞队列
    private final BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);

    //取消息
    public Message next() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    //消息入队
    public void enqueueMessage(Message msg) {
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
