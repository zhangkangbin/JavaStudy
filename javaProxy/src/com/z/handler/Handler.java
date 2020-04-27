package com.z.handler;

import java.util.concurrent.LinkedBlockingQueue;

public class Handler {

    private Looper looper;

    public LinkedBlockingQueue<Message> queue;

    public Handler() {

        looper = Looper.getLooper();
        queue = looper.queue;
    }

    public void sendMessage(int what, String msg) {

        queue.add(new Message(what, msg, this));
    }

    public void handleMessage(Message message) {

    }
}
